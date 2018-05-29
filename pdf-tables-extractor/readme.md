# Date Range Annotator

This is a docker image wrapper around the [PDF tables extractor](https://github.com/ewoij/pdf-tables-extractor).

The docker image is following the component OpenMinTeD guidelines.

## Usage

```
docker run <image-name> extracts --help
```

```
usage: extracts [-h] --input INPUT_FOLDER --output OUTPUT_FOLDER
                [--output-mode {Flat,Deep}]

optional arguments:
  -h, --help            show this help message and exit
  --input INPUT_FOLDER
  --output OUTPUT_FOLDER
  --output-mode {Flat,Deep}
``` 