package date_range_annotator;

import java.io.File;

import com.github.ewoij.openminted.components.date_range_annotator.Javadoc;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;

public class App {
    public static void main(String[] args) throws Exception {
        File inputDirectory = new File(args[0]);
        File outputDirectory = new File(args[1]);

        String dateRangeAnalysisEnginePath = Javadoc.class.getResource("MainRutaAnalysisEngine.xml").toString();

        SimplePipeline.runPipeline(
            CollectionReaderFactory.createReaderDescription(
                XmiReader.class, 
                XmiReader.PARAM_SOURCE_LOCATION, inputDirectory.toString() + "/*.xmi"), 
            AnalysisEngineFactory.createEngineDescriptionFromPath(dateRangeAnalysisEnginePath),
            AnalysisEngineFactory.createEngineDescription(
                XmiWriter.class,
                XmiWriter.PARAM_TARGET_LOCATION, outputDirectory.toString(),
                XmiWriter.PARAM_OVERWRITE, true));
    }
}
