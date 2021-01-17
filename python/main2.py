import requests
import infermedica_api
import pyaudio
import keyboard
import numpy as np
from scipy.io import wavfile
import speech_recognition as sr
import pyttsx3

import DiagnosisAPI
from DiagnosisAPI import NLP_api_request
from DiagnosisAPI import symptom_name_list
from DiagnosisAPI import symptom_id_list
from DiagnosisAPI import add_symptoms

import SpeechRecog
from SpeechRecog import SpeakText
from SpeechRecog import Recorder
from SpeechRecog import audio_recording
from SpeechRecog import speech_to_text

def add_words(transcription):
    global total_symptom_list
    global dictionary_list
    global total_list

    dictionary_list = NLP_api_request(transcription)
    total_symptom_list = symptom_name_list(dictionary_list)
    total_list = symptom_id_list(dictionary_list)

    return (total_list)


infermedica_api.configure(app_id='eed1bf00', app_key='77bdcb20a29e9c221fd064d5c250c51f')
total_list = []
symptoms_list = []
total_symptom_list = []
dictionary_list = []


add_words(input("How are you feeling today?"))

add_words(input("What symptoms do you have?"))

add_words(input("Is there anything else you would like to talk about?"))

print(total_list)
diagnosis = add_symptoms(total_list)

print("Your Apollo diagnosis is: ", diagnosis)

