import jdk.management.resource.internal.inst.NetRMHooks;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.imgrec.ImageRecognitionPlugin;
import org.neuroph.nnet.Perceptron;


import java.util.HashMap;
import java.io.File;
import java.io.IOException;

/**
 * Created by matus.vida on 16. 10. 2015.
 */
public class Recognition {

    NeuralNetwork neuralNetwork = new Perceptron(2, 1);




    public static void main(String[] args) {
        // load trained neural network saved with Neuroph Studio (specify some existing neural network file here)
        NeuralNetwork nnet = NeuralNetwork.load("MyImageRecognition.nnet"); // load trained neural network saved with Neuroph Studio
        // get the image recognition plugin from neural network
        ImageRecognitionPlugin imageRecognition = (ImageRecognitionPlugin)nnet.getPlugin(ImageRecognitionPlugin.class); // get the image recognition plugin from neural network

        try {
            // image recognition is done here (specify some existing image file)
            HashMap<String, Double> output = imageRecognition.recognizeImage(new File("image.jpg"));
            System.out.println(output.toString());
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
