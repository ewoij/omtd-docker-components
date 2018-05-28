import sys
import os
import xml.etree.ElementTree as ET

version = '1.0.0'
docker_repository = 'ewoij/item-event-annotator'
docker_tag = version
docker_image = '{}:{}'.format(docker_repository, docker_tag)
docker_volume = os.path.abspath('../..')
docker_volume_dest = '/data'
run_command = 'annotates'
run_input_dir = '/data/_test_corpus/hsm-test'
run_output_dir = '/data/omtd-docker-components/item-events-annotator/corpus_output'
omtd_shema_file = 'omtd_share.xml'

# decorator
def run(func):
    def wrapper():
        cmd = func()
        print('Running: {}'.format(cmd))
        os.system(cmd)
    return wrapper

# commands
@run
def push_docker_image():
    return 'docker push {}'.format(docker_image)

@run
def build_docker_image():
    build_jar()
    return 'docker build -t {} .'.format(docker_image)

@run
def run_docker_image_app():
    build_docker_image()
    return 'docker run -v "{}:{}" {} {} --input {} --output {}'.format(docker_volume, docker_volume_dest, docker_image, run_command, run_input_dir, run_output_dir)

@run
def run_docker_image():
    build_docker_image()
    return 'docker run --rm -it {}'.format(docker_image)

@run
def clean():
    return 'mvn clean'

@run
def build_jar():
    clean()
    return 'mvn "-D_version={}" package'.format(version)

def update_omtd_schema():
    ns = '{http://www.meta-share.org/OMTD-SHARE_XMLSchema}'
    ET.register_namespace('', ns[1:-1])
    root = ET.parse(omtd_shema_file)
    root.find('./{ns}componentInfo/{ns}versionInfo/{ns}version'.format(ns=ns)).text = version
    root.find('./{ns}componentInfo/{ns}distributionInfos/{ns}componentDistributionInfo/{ns}distributionLocation'.format(ns=ns)).text = '{}:{}'.format(docker_repository, docker_tag)
    root.find('./{ns}componentInfo/{ns}distributionInfos/{ns}componentDistributionInfo/{ns}command'.format(ns=ns)).text = run_command
    root.write(omtd_shema_file)

def build():
    build_docker_image()
    update_omtd_schema()

if __name__ == '__main__':
    command = sys.argv[1]
    globals()[command]()
