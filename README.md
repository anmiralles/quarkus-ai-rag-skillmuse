# ai-rag-skillmuse

This project is a simple example about how to interact with a LLM (Large Language Model) through Quarkus
and LangChain4j library.

LangChain4j allow us to integrate AI/LLM capabilities into our Java applications.

As LLM server we will use Ollama, more info on this her https://ollama.com/.

We also implemented RAG (Retrieval Augmented Generation) pattern to enhance our model with ingested documents. More info in this link:

https://docs.quarkiverse.io/quarkus-langchain4j/dev/retrievers.html

## Running the application in dev mode

Once Ollama has been installed, you can start serving the desire LLM model, in this case I have downloaded
llama2:latest model

```
ollama run llama2:latest
```

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

Finally you can start submitting your requests like this:

```
curl -i -X POST --header 'Content-Type: text/plain' --data "tell me more about Sevilla" http://localhost:8080/chat
```