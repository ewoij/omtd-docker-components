# Item Events Annotator

This is a docker image wrapping a UIMA pipeline annotating sentences, items and events.

The sentences are annotated using the [DKPro component opennlp segmenter](https://dkpro.github.io/dkpro-core/releases/1.9.2/docs/component-reference.html#engine-OpenNlpSegmenter).

The items are annotated using a dictionary which defaults to a list of liver disease built from a subset of the NCIT ontology.

The events are annotated using a list. The default list contains a set of progression keywords.

For both the items and events, files to be used can be specified as argument.

## Usage

```
docker run <image-name> annotates --help
```

```
usage: annotates [-h] --input INPUT_DIR --output OUTPUT_DIR
                 [--item-dic ITEM_DIC] [--event-list EVENT_LIST]

optional arguments:
  -h, --help            show this help message and exit
  --input INPUT_DIR
  --output OUTPUT_DIR
  --item-dic ITEM_DIC
  --event-list EVENT_LIST
```