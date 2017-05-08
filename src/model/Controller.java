package model;

import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;

import java.awt.*;

/**
 * Created by Немченко Анна on 24.04.2017.
 */
public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    private ImageView originalView, modifiedView;
    private TextArea text, resultText;

//    public void injectUI(ImageView original, TextArea text, TextArea resultText) {
//        this.originalView = original;
//
//        this.text = text;
//        this.resultText = resultText;
//    }

    public void onEncode(ImageView original, TextArea text, ImageView modifiedView) {
        this.originalView = original;
        this.text = text;
        this.modifiedView = modifiedView;
        Image modified = model.encode(originalView.getImage(), text.getText(), 1);
        modifiedView.setImage(modified);
    }

    public void onDecode(ImageView modified, TextArea resultText) {
        this.modifiedView = modified;
        String message = model.decode(modifiedView.getImage());
        resultText.setText(message);
    }
}
