import random

class AI(object):
    def __init__(self, ball_x, ball_y):
        self.ball_x = ball_x
        self.ball_y = ball_y
        self.rand = random.randint(1, 200)

    def move_paddle(self):
        return self.ball_x - 100
