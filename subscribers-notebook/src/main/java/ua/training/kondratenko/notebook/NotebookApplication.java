package ua.training.kondratenko.notebook;

public class NotebookApplication {

    public static void main(String[] args) {

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);

        controller.notebookFilling();
//        Scanner scanner = new Scanner(System.in);
//
//        Pattern namePattern = Pattern.compile("[A-Z][a-z]+");
//
//        view.printMessage(View.ENTER_A_NAME);
//
//        String correctName = null;
//
//        // enter name
//
////        correctName = getCorrectValue(scanner, namePattern);
//
//        view.printMessage(View.NAME_ACCEPTED + correctName);
//
//        scanner.close();
    }

}
