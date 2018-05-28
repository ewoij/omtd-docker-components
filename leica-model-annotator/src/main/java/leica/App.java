package leica;

import java.io.File;

import com.github.ewoij.openminted.components.leica_model_annotator.Javadoc;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;

public class App {
    public static void main(String[] args) throws Exception {
        File inputDirectory = new File(args[0]);
        File outputDirectory = new File(args[1]);

        String leicaAnalysisEnginePath = Javadoc.class.getResource("LeicaModelAnnotatorRutaAnalysisEngine.xml").toString();

        SimplePipeline.runPipeline(
            CollectionReaderFactory.createReaderDescription(
                XmiReader.class, 
                XmiReader.PARAM_SOURCE_LOCATION, inputDirectory.toString() + "/*.xmi"), 
            AnalysisEngineFactory.createEngineDescriptionFromPath(leicaAnalysisEnginePath),
            AnalysisEngineFactory.createEngineDescription(
                XmiWriter.class,
                XmiWriter.PARAM_TARGET_LOCATION, outputDirectory.toString(),
                XmiWriter.PARAM_OVERWRITE, true));
    }
}
