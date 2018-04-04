import unittest
from tictoc import inputMove, isSpotEmpty, game_winner


class testInputMove(unittest.TestCase):
    # Check if input can be passed as two number values
    def testInputMV(self):
        self.assertTrue(inputMove("1,2") == "1,2")

    # Checkif spot is already occupied.
    def testIsSpotEmpty(self):
        game = [["O", "X", " "], [" ", " ", " "], [" ", " ", " "]]
        self.assertTrue(isSpotEmpty(game, 1, 1))

    # Check if input is out of range
    def testOutOfRange(self):
        try:
            game = [["O", "X", " "], [" ", " ", " "], [" ", " ", " "]]
            self.assertFalse(isSpotEmpty(game,1,4))
        except IndexError:
            pass

    # Check if game_winner declared correct winner
    def testgame_winner(self):
        game = [["O", "X", "X"], ["O", "X", "X"], ["O", "O", "O"]]
        self.assertTrue(game_winner(game)=="O")

    
if __name__ == '__main__':
    unittest.main()        
    raise SystemExit("Good")