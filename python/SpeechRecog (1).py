import pyaudio
import keyboard
import numpy as np
from scipy.io import wavfile
import speech_recognition as sr
import pyttsx3

def SpeakText(command): 
    
    # Initialize the engine 
    engine = pyttsx3.init() 
    engine.say(command)  
    engine.runAndWait() 

class Recorder():
    def __init__(self, filename):
        self.audio_format = pyaudio.paInt16
        self.channels = 1
        self.sample_rate = 44100
        self.chunk = int(0.03*self.sample_rate)
        self.filename = filename
        self.START_KEY = 's'
        self.STOP_KEY = 'q'

    def record(self):
        recorded_data = []
        p = pyaudio.PyAudio()

        stream = p.open(format=self.audio_format, channels=self.channels,
                        rate=self.sample_rate, input=True,
                        frames_per_buffer=self.chunk)
        while(True):
            data = stream.read(self.chunk)
            recorded_data.append(data)
            if keyboard.is_pressed(self.STOP_KEY):
                print("Stop recording")
                # stop and close the stream
                stream.stop_stream()
                stream.close()
                p.terminate()
                #convert recorded data to numpy array
                recorded_data = [np.frombuffer(frame, dtype=np.int16) for frame in recorded_data]
                wav = np.concatenate(recorded_data, axis=0)
                wavfile.write(self.filename, self.sample_rate, wav)
                print("You should have a wav file: transcribed_audio.wav,  in your current directory")
                break

    def listen(self):
        print(f"Press `{self.START_KEY}` to start and `{self.STOP_KEY}` to quit!")
        while True:
            if keyboard.is_pressed(self.START_KEY):
                self.record()
                break

def audio_recording():
    recorder = Recorder("transcribed_audio.wav") #name of output file
    recorder.listen()

def speech_to_text():
    import speech_recognition as sr   
    r = sr.Recognizer() 
    
    with sr.AudioFile("transcribed_audio.wav") as source: 
        #reads the audio file. Here we use record instead of 
        #listen 
        audio = r.record(source)   
    
    try: 
        transcription = r.recognize_google(audio).lower()
        print("Transcription: " + transcription) 
        #transcribed_list = transcription.split()
        #print(transcribed_list)

    except sr.UnknownValueError:
        print("Apollo could not understand you, please try again")
        SpeakText("Apollo could not understand you, please try again")
            
    except sr.RequestError as e: 
        print("Could not request results; {0}".format(e)) 

    return transcription

''' 
audio_recording()
transcription = speech_to_text()
print(transcription)
'''