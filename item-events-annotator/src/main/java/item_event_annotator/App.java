package item_event_annotator;

import java.io.File;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.ruta.engine.RutaEngine;

import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiReader;
import de.tudarmstadt.ukp.dkpro.core.io.xmi.XmiWriter;
import de.tudarmstadt.ukp.dkpro.core.opennlp.OpenNlpSegmenter;

public class App
{
    public static void main(String[] args) throws Exception
    {
    	File inputDirectory = new File(args[0]);
        File outputDirectory = new File(args[1]);

		String rutaResourcesDir = "ruta_resources";

        SimplePipeline.runPipeline(
            CollectionReaderFactory.createReaderDescription(
                XmiReader.class, 
                XmiReader.PARAM_SOURCE_LOCATION, inputDirectory.toString() + "/*.xmi"),
            AnalysisEngineFactory.createEngineDescription(OpenNlpSegmenter.class),
            AnalysisEngineFactory.createEngineDescription(RutaEngine.class,
                RutaEngine.PARAM_MAIN_SCRIPT, "ruta.item_event_annotator.MarkItems",
                RutaEngine.PARAM_RESOURCE_PATHS, rutaResourcesDir),
            AnalysisEngineFactory.createEngineDescription(RutaEngine.class,
                RutaEngine.PARAM_MAIN_SCRIPT, "ruta.item_event_annotator.MarkEvents",
                RutaEngine.PARAM_RESOURCE_PATHS, rutaResourcesDir),
            AnalysisEngineFactory.createEngineDescription(
                XmiWriter.class,
                XmiWriter.PARAM_TARGET_LOCATION, outputDirectory.toString(),
                XmiWriter.PARAM_OVERWRITE, true));
    }
}
