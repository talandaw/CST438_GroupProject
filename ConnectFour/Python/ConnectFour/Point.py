import os
import random
import time
from abc import ABCMeta, abstractmethod

class Point(object):

    def __init__(self):
        self.x = None
        self.y = None

    def __str__(self):
        return str((self.x, self.y))

    def __repr__(self):
        return self.__str__()

    def getX(self):
        return self.x

    def getY(self):
        return self.y

    def setX(self, x):
        self.x = x

    def setY(self, y):
        self.y = y