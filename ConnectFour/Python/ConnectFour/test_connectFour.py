import unittest
from ConnectFour import ConnectFour 
from ConnectFour import Point
from ConnectFour import Model

class TestConnectFour(unittest.TestCase):

    def setUp(self):
        self.connect_four = ConnectFour()

    def test_setX(self):
        self.assertEqual(Point.setX(self, 5), 5)  
        self.assertEqual(Point.setX(self, -5), -5)
        self.assertEqual(Point.setX(self, 0), 0) 

    def test_setY(self):
        self.assertEqual(Point.setY(self, 5), 5)  
        self.assertEqual(Point.setY(self, -5), -5)
        self.assertEqual(Point.setY(self, 0), 0) 

    def test_horizontalWin(self):
        board[3][0] == 1 
        board[3][0] == board[3][1] 
        board[3][0] == board[3][2]  
        board[3][0] == board[3][3]		  
        Model.win(self)
        self.assertEqual(self.connect_four._is_connect_four(), True)

    def test_verticalWin(self):

        board[3][0] == 1 
        board[3][0] == board[2][0] 
        board[2][0] == board[1][0] 
        board[1][0] == board[0][0]
        Model.win(self)
        self.assertEqual(self.connect_four._is_connect_four(), True)

    def test_diagonalWin(self):
        board[3][0] == 1 
        board[3][0] == board[2][1] 
        board[2][1] == board[1][2] 
        board[1][2] == board[0][3]
        Model.win(self)
        self.assertEqual(self.connect_four._is_connect_four(), True)

if __name__ == '__main__':
    unittest.name()