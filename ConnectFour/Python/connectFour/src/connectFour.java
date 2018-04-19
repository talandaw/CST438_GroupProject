
public class connectFour {
	public static void main(String[] args){
       Controller controller = new Controller();
       View view = new View(controller);
       Model model = new Model(view);
       controller.setup(model);
       view.setVisible(true);
   }
}
