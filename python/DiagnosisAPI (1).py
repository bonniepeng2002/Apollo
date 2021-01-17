import requests
import infermedica_api

#transcript = "my stomach hurts today but I am not coughing"
symptoms_list = []
total_list = []

def NLP_api_request(transcript):
    

    URL = "https://api.infermedica.com/v2/parse" 
    APP_ID = "eed1bf00"
    APP_KEY = "77bdcb20a29e9c221fd064d5c250c51f"

    HEADERS = {
        "App-ID": APP_ID,
        "App-Key": APP_KEY,
        "Content-Type": "application/json",
    }

    BODY = {
        #"text": "i feel stomach pain but no coughing today"
        "text": transcript
    }

    if True:
        #this was if __name__ == "__main__":
        res = requests.post(URL, json=BODY, headers=HEADERS)
        #print(res.status_code)
        #print(res.json())   

    return res.json()


def symptom_name_list(dictionary_list):
    api = infermedica_api.get_api()
    # Create diagnosis object with initial patient information.
    request = infermedica_api.Diagnosis(sex='male', age=35)

    #Uses res.json dictionary of list of dictionaries 
    list_of_dictionaries = dictionary_list['mentions']
    #print(list_of_dictionaries)

    print("Your symptoms are: ")

    for i in range(len(list_of_dictionaries)):
        print(list_of_dictionaries[i]["name"])
        symptoms_list.append(list_of_dictionaries[i]["name"])

    print(symptoms_list)
    return symptoms_list


def symptom_id_list(dictionary_list):
    api = infermedica_api.get_api()
    # Create diagnosis object with initial patient information.
    request = infermedica_api.Diagnosis(sex='male', age=35)

    #Uses res.json dictionary of list of dictionaries 
    list_of_dictionaries = dictionary_list['mentions']
    #print(list_of_dictionaries)

    for i in range(len(list_of_dictionaries)):
        total_list.append([list_of_dictionaries[i]["id"], list_of_dictionaries[i]["choice_id"]])

    return total_list

def add_symptoms(total_list):
    api = infermedica_api.get_api()
    # Create diagnosis object with initial patient information.
    request = infermedica_api.Diagnosis(sex='male', age=35)
    
    for i in range(len(total_list)):
        request.add_symptom(str(total_list[i][0]), str(total_list[i][1]))
        #print(str(id_list[i]), str(choiceid_list[i]))

    # call diagnosis
    request = api.diagnosis(request)

    #print(request.conditions[0]['id'])
    #print(request.conditions[0]['name'])
    #print(request.conditions[0]['probability'])

    return request.conditions[0]['name']



'''
infermedica_api.configure(app_id='eed1bf00', app_key='77bdcb20a29e9c221fd064d5c250c51f')
total_list = []
symptoms_list = []

dictionary_list = NLP_api_request(transcript)
symptom_list = symptom_name_list(dictionary_list)
total_list = symptom_id_list(dictionary_list)
diagnosis = add_symptoms(total_list)
print(diagnosis)
'''