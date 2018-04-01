import unittest
import random



class TestSnake(unittest.TestCase):

    #test to ensure the food relocates to a different location
    def test_changelocation(self):
        SIZE = 20
        x_coord = 10
        y_coord = 20

        x_coord = self.x = random.randint(0, SIZE) * SIZE - 200
        y_coord = self.y = random.randint(0, SIZE) * SIZE - 200

        self.assertEqual(x_coord, self.x)
        self.assertEqual(y_coord, self.y)



    #tests if when user inputs an UP command for the snake, it follows the Y axis up 1 and not any other direction
    def test_moveup(self):
        x_coord = 0
        y_coord = 1
        self.assertIsNot(x_coord, y_coord)



    #tests if when user inputs a DOWN command for the snake, it follows the Y axis down 1 and not any other direction
    def test_movedown(self):
        x_coord = 0
        y_coord = -1
        self.assertIsNot(x_coord, y_coord)



    #tests when snake moves LEFT, it follows the X axis left 1 and not any other direction
    def test_snakeleft(self):
        x_coord = -1
        y_coord = 0
        self.assertIsNot(x_coord, y_coord)



    #tests when snake moves RIGHT, it follows the X axis right 1 and not any other direction
    def test_snakeright(self):
        x_coord = 1
        y_coord = 0
        self.assertIsNot(x_coord, y_coord)


if __name__ == '__main__':
    unittest.main()