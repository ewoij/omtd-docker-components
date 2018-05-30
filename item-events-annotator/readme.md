# Item Events Annotator

This is a docker image wrapping a UIMA pipeline annotating sentences, items and events.

The sentences are annotated using the [DKPro component opennlp segmenter](https://dkpro.github.io/dkpro-core/releases/1.9.2/docs/component-reference.html#engine-OpenNlpSegmenter).

The items are annotated using a dictionary of liver disease built from a subset of the NCIT ontology.

The events are annotated using a list containing a set of progression keywords.

## Usage

```
docker run <image-name> annotates --help
```

```
usage: annotates [-h] --input INPUT_DIR --output OUTPUT_DIR

optional arguments:
  -h, --help           show this help message and exit
  --input INPUT_DIR
  --output OUTPUT_DIR
```