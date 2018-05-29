import os
import glob
import shutil
import xml.etree.ElementTree as ET

def get_app_name(fp):
    return os.path.basename(os.path.dirname(fp))

def get_version(fp):
    ns = '{http://www.meta-share.org/OMTD-SHARE_XMLSchema}'
    return ET.parse(fp).find('./{ns}componentInfo/{ns}versionInfo/{ns}version'.format(ns=ns)).text

def get_output_file_name():
    return '{}.{}.omtd.xml'.format(get_app_name(fp), get_version(fp))

def get_output_file_path():
    return os.path.join('omtd_share_descriptors', get_output_file_name())

for fp in glob.glob('**/omtd_share.xml'):
    output_file_path = get_output_file_path()
    os.makedirs(os.path.dirname(output_file_path), exist_ok=True)
    shutil.copy2(fp, output_file_path)
