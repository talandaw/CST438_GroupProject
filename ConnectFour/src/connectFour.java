public class connectFour {
	   public static void main(String[] args)
	   {
      //
      // --- Create the Model, View and Controller
      //
       Controller controller = new Controller();
       View view = new View(controller);
       Model model = new Model(view);
       controller.setup(model);
       //
       // Show view
       //
       view.setVisible(true);
   }
}
