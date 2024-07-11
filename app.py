import openai
import os

# Set your OpenAI API key from environment variable
openai.api_key = os.getenv("OPENAI_API_KEY")

# Define the path to your file containing the course list
file_path = '/Users/panzhiheng1/Downloads/Computer_Science/ClassScheduleProject/ClassScheduleProject/ClassScheduleProject/class.txt'

# Read the content of the file
with open(file_path, 'r') as file:
    course_list = file.read()

# Split the course list into smaller chunks to fit within the token limit
chunk_size = 1000  # Adjust chunk size as needed to stay within the token limit
courses = course_list.split(',')
chunks = [','.join(courses[i:i + chunk_size]) for i in range(0, len(courses), chunk_size)]

# Process each chunk separately
responses = []
for chunk in chunks:
    messages = [
        {"role": "system", "content": "You are a helpful assistant."},
        {"role": "user", "content": f"Here is a list of courses with details: {chunk}Choose 4 from them to form a reasonable class schedule for me."}
    ]

    # Send the request to the OpenAI API
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=messages,
        max_tokens=150  # Adjust the max tokens as needed
    )

    # Collect the response
    responses.append(response.choices[0].message['content'].strip())

# Print all responses
for response in responses:
    print(response)

