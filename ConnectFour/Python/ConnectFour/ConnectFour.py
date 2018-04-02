import os
import random
import time
import View

from abc import ABCMeta, abstractmethod

class connectFour(object): 
    def main():
     #   //
      #  // --- Create the Model, View and Controller
       # //
       controller = controller()
       view = View(controller)
       model = Model(view)
       controller.setup(model);
      #  //
       # // Show view
       # //
       view.setVisible(true)
       