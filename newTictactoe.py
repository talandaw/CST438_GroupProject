def display_rule():
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    print("TIC TAC TOE!")
    print("The ROWS & COLUMNS start at 1,1. The first number is the ROW and the second is the COLUMN.")
    print("Enter your selection in the following format, ex: 1,2 or 3,2 or 2,3")
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    print("\n")



def game_winner(game):
    for i in range(3):
        row = set(game[i])
        if len(row) == 1 and game[i][2] != 0:
            return game[i][2]

    for j in range(3):
        column = set([game[0][j], game[1][j], game[2][j]])
        if len(column) == 1 and game[1][j] != 0:
            return game[1][j]

    diag1 = set([game[0][0], game[1][1], game[2][2]])
    diag2 = set([game[0][2], game[1][1], game[2][0]])
    if len(diag1) == 1 or len(diag2) == 1 and game[1][1] != 0:
        return game[1][1]

    return "No One"


def inputMove(inputx=""):
    if inputx=="" :
       return input("Enter your selection in the following format, ex: 1,2 or 3,2 or 2,3: ")
    else:
        return inputx

def isSpotEmpty(game,row,column):
   if game[row][column] == " ":
       return True
   else:
       return False 

def start_game(game):
    print("\n")
    for i in range(3):
        print("  |  ".join(str(x) for x in game[i]))
        if i < 2:
            print("-------------")



if __name__ == "__main__":

    display_rule()
    ans = 'y'
    count_x = 0
    count_o = 0

    while ans != 'n':
        game = [[" ", " ", " "], [" ", " ", " "], [" ", " ", " "]]

        start_game(game)

        count = 0
        chance = True

        while chance:
            spot = inputMove()

            spot = spot.split(",")  # gives strings

            row = int(spot[0]) - 1
            column = int(spot[1]) - 1

            if count % 2 == 0:
                print("\nPlayer 1's turn!")
                if isSpotEmpty(game,row,column) :
                    game[row][column] = 'X'
                else:
                    print("That spot is already taken. Try another spot!")
                    count -= 1
                start_game(game)


            else:
                print("\nPlayer 2's turn!")
                if isSpotEmpty(game,row,column) :
                    game[row][column] = 'O'
                else:
                    print("That spot is already taken. Try another spot!")
                    count -= 1
                start_game(game)

            count += 1

            if " " in game[0] or " " in game[1] or " " in game[2]:
                chance = True
            else:
                chance = False
                print("Tie Game!")

            if game_winner(game) == 'X':
                print("The winner is ", game_winner(game))
                count_x += 1
                break
            elif game_winner(game) == 'O':
                print("The winner is ", game_winner(game))
                count_o += 1
                break
            else:
                print("No winner yet, please continue.")

        ans = input("Play Again? [Y/N]): ")

    print("Good game!")
    print("Total Score for this session: \n\nPlayer 1: %s \nPlayer 2: %s" % (count_x, count_o))