## Recrutamento Android - Movile

![Hero image](art/hero.jpg =600x)

---

## Sobre

Projeto teste para processo seletivo da vaga de desenvolvedor Android da Movile. O aplicativo consiste em um cliente simples do [Trakt.tv](http://trakt.tv) que trás informações de uma série, como a lista de episódios de uma temporada e outros detalhes, como imagens e rating.


## Características

#### API
Trakt.tv (Docs): [http://docs.trakt.apiary.io/](http://docs.trakt.apiary.io/)


#### Arquitetura e Libraries

* Arquitetura MVP
* API mínima 16 e target 23
* Android Support Library 23.2.0
* Cliente REST/HTTP com Retrofit + OkHttp
* Carregamento de imagens com Picasso
* View binding com Butterknife
* Testes unitários com JUnit + Hamcrest + Mockito
* Testes de UI/funcionais com Espresso

#### Requisitos

* Layout diferente para landscape ✔︎
* Tratamento de erros (falta de conexão, erros do servidor) ✔︎
* Efeito parallax no cabeçalho ✔︎
* Tornar a toolbar opaca conforme o scroll da listagem de episódios ✔︎
* Testes automatizados ✔︎
* Layout diferente para tablet ou orientação landscape ✔︎

## Como gerar uma build?

Para fazer build do projeto é necessário criar um arquivo de nome `secret.properties` na raiz do projeto, contendo um Client ID válido do Trakt.tv no seguinte formato:

	API_KEY=your_client_id

Para conseguir o Client ID basta acessar [esse link](https://trakt.tv/oauth/applications/new) e criar uma nova aplicação no Trakt.tv.

Essa configuração é necessária pois dentro do `build.gradle` existe o método *getAPIKey* que lê o arquivo `secret.properties` e retorna o Client ID dinamicamente:

```groovy
def getAPIKey() {
   	def Properties props = new Properties()
    props.load(new FileInputStream(new File('secret.properties')))
   	return props['API_KEY']
}
```

Dessa forma, podemos criar um *buildConfigField* custom no `app/build.gradle`:

```groovy
buildConfigField "String", "API_KEY", "\""+getAPIKey()+"\""
```
E acessar esse valor dentro do projeto, através de uma constante da classe `BuildConfig.java`, que gerada automaticamente após o build do Gradle:

```java
BuildConfig.API_KEY
```

Esse apprach é recomendado pois evita que o Client ID seja commitado junto com o projeto.




