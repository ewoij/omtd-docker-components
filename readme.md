# OpenMinTeD Docker Components

This project contains the necessities to build OpenMinTed docker compatible components.

## How to build

Each subproject contains a build.py script.

These scripts typically contains a set of commands to build specific targets. The commands are usually the following:
 - clean
 - build_jar
 - build_docker_image
 - run_docker_image
 - run_docker_image_app
 - push_docker_image
 - update_omtd_schema
 - release

Some commands may depends on others, there is no need to run multiple commands since the dependencies are automatically built.

Each component build contains a set of parameters such as 'version', 'docker_repository', etc. The parameters are listed at the top of every build scripts.

Example of a command:

```bash
python build.py run_docker_image_app
```

The example above will:
 - build the maven project using the specified version
 - create a docker image including the output of the maven build. The image repository and tag name will be retrieved from the build parameters.
 - run the image with a docker volume targeting the test corpus, and passing the relevant paramters to run the app.

The usual build lifecycle is as follows:

![omtd-components-build-lifecycle](https://user-images.githubusercontent.com/5585520/40659796-994edfa0-634f-11e8-9250-27fd2779495c.png)

## Requirements
 - Java 8 SDK
 - Apache Maven 3.5.0
 - Python 3.6
 - Docker
