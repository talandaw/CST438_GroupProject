import pygame
from pygame.locals import *
import random
import time
from . import ai as ai_paddle




class AI(object):
    def __init__(self, ball_x, ball_y):
        self.ball_x = ball_x
        self.ball_y = ball_y
        self.rand = random.randint(1, 200)

    def move_paddle(self):
        return self.ball_x - 100



class Pong(object):

    def info(self):
        self.info_division_y = self.info_area - 5
        pygame.draw.rect(self.display, self.color_3,
                        (0, self.info_division_y, 
                         self.display_width, self.info_division_height))
        
        pygame.font.init()
        font = pygame.font.SysFont("arial", 20)
        left_label = font.render("%d" %self.score[0], 1, self.color_3)
        self.display.blit(left_label, (45, 13))
        right_label = font.render("%d" %self.score[1], 1, self.color_3)
        self.display.blit(right_label, (596, 13))
        reset_label = font.render("     Press ENTER reset the game", 1, self.color_3)
        self.display.blit(reset_label, (240, 2))
        quit_label = font.render("Press ESCAPE to exit the game", 1, self.color_3)
        self.display.blit(quit_label, (267, 20))

    def reset(self):
        key = pygame.key.get_pressed()

        if key[K_RETURN]:
            self.ball_x = random.randint(300, 340)
            self.ball_y = random.randint(0, 50)
            self.left_paddle_mv = self.right_paddle_mv = random.randint(300,340)
            self.direction = [1, 1]
            self.score = [0, 0]
            time.sleep(1)

    def update_puck(self):
        self.ball_x += self.speed * self.direction[0]
        self.ball_y += self.speed * self.direction[1]
    
        self.ball_rect = pygame.Rect(self.ball_x,self.ball_y,
                                self.ball_side,self.ball_side)
        
        if (self.ball_rect.right >= self.display_width - self.paddle_width) and (self.ball_rect.right <= self.display_width - 1):
            if (self.ball_rect.top - 10 >= self.right_paddle_mv) and (self.ball_rect.bottom - 10 <= self.right_paddle_mv + 75):
                self.direction[0] = -1
                self.play_sound()

        if (self.ball_rect.right >= self.display_width):
            self.direction[0] = -1
            self.hit_edge_left = True
            
        if (self.ball_rect.left <= self.paddle_width) and (self.ball_rect.left >= 0):
            if (self.ball_rect.top - 10 >= self.left_paddle_mv) and (self.ball_rect.bottom - 10 <= self.left_paddle_mv + 75):
                self.direction[0] = 1
                self.play_sound()

        if(self.ball_rect.left <= 0):
            self.direction[0] = 1
            self.hit_edge_right = True

        if self.ball_rect.top <= self.game_area_top:
            self.direction[1] = 1
            self.play_sound()

        if self.ball_rect.bottom >= self.game_area_bottom:
            self.direction[1] = -1
            self.play_sound() 

        pygame.draw.rect(self.display, self.color_2, 
                         (self.ball_x, self.ball_y, self.ball_side, self.ball_side)
                        )
        
        tally = [0, 0]
        if self.hit_edge_left:
            tally[0] += 1
            self.hit_edge_left = False
        if self.hit_edge_right:
            tally[1] += 1
            self.hit_edge_right = False
        
        self.score[0] = self.score[0] + tally[0]
        self.score[1] = self.score[1] + tally[1]

    def __init__(self,width,height):
        pygame.init()
        pygame.mixer.init()
        pygame.display.set_caption("Pong")
        self.sound = pygame.mixer.Sound("Game/ball.wav")
        self.display_width = width
        self.display_height = height
        self.display = pygame.display.set_mode((self.display_width, self.display_height))
        self.bg_color = (0,0,0)
        self.ball_x = random.randint(300, 340)
        self.ball_y = random.randint(0, 50)
        self.left_paddle_mv = self.right_paddle_mv = self.centery = 240
        self.ball_side = 15
        
        self.color = (41,128,185)
        self.color_1 = (18,170,40) 
        self.color_2 = (255,255,255)
        self.color_3 = (255,255,255) 
        self.direction = [1,1]
        self.speed = 7;
        
        self.hit_edge_left = False
        self.hit_edge_right = False
        
        self.paddle_height = 90
        self.paddle_width = 20
        
        self.info_division_height = 5
        self.info_area = (0.1 * self.display_height)  
        self.game_area_top = self.info_area
        self.game_area_bottom = self.display_height
        
        self.score = [0, 0]

    def play_sound(self):
        self.channel = self.sound.play()
        self.sound.set_volume(0.8)

    def fill(self):
        self.display.fill(self.bg_color)

    def right_paddle(self, ai=None):
        if ai == None: 
            key = pygame.key.get_pressed()
            if key[K_UP]:
                self.right_paddle_mv = self.right_paddle_mv - 4
            if key[K_DOWN]:
                self.right_paddle_mv = self.right_paddle_mv + 4

        else:
            self.ai = ai_paddle.AI(self.ball_x,self.ball_y)
            self.right_paddle_mv = self.ai.move_paddle()

        if self.right_paddle_mv <= self.game_area_top:
            self.right_paddle_mv = self.game_area_top
        if self.right_paddle_mv + self.paddle_height >= self.game_area_bottom:
            self.right_paddle_mv = self.game_area_bottom - self.paddle_height
            
        pygame.draw.rect(self.display, self.color,
                         (self.display_width - self.paddle_width,
                         self.right_paddle_mv, self.paddle_width, self.paddle_height)
                        )

    def left_paddle(self, ai = 1):
        if ai == None: 
            key = pygame.key.get_pressed()
            if key[K_w]:
                self.left_paddle_mv = self.left_paddle_mv - 4
            if key[K_s]:
                self.left_paddle_mv = self.left_paddle_mv + 4

        else:
            self.ai = ai_paddle.AI(self.ball_x,self.ball_y)
            self.left_paddle_mv = self.ai.move_paddle()

        if self.left_paddle_mv <= self.game_area_top:
            self.left_paddle_mv = self.game_area_top
        if self.left_paddle_mv + self.paddle_height >= self.game_area_bottom:
            self.left_paddle_mv = self.game_area_bottom - self.paddle_height

        pygame.draw.rect(self.display, self.color_1,
                         (0,         
                         self.left_paddle_mv, self.paddle_width, self.paddle_height)
                        )     


