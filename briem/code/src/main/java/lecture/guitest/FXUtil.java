package lecture.guitest;


import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;

public class FXUtil {

    private static final String FXML_EXTENSION = ".fxml";


    /**
     * Loads a FXML file with the same name as the controller. IOExceptions will
     * be thrown as RuntimeExceptions to keep client code clean.
     *
     * @param controller
     * @param root
     * @return
     */
    public static <T> T load(Object controller, Object root) {
        URL resource = findResource(controller);
        return loadWithFXMLLoader(controller, root, resource);
    }

    private static URL findResource(Object controller) {
    	String simpleName = controller.getClass().getSimpleName();
    	String fileName = simpleName.concat(FXML_EXTENSION);
    	return controller.getClass().getResource(fileName);
    }

    private static <T> T loadWithFXMLLoader(Object controller, Object root, URL resource) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(resource);
            fxmlLoader.setRoot(root);
            fxmlLoader.setController(controller);
            return fxmlLoader.load();
        } catch (IOException | IllegalArgumentException exception) {
            throw new RuntimeException(exception);
        }
    }

}
