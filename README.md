# Sr. Barriga

Este projeto é uma automação para estudo em uma aplicação real chamada, Sr Barriga que foi desenvolvido por Franscisco Wagner. Os testes foram desenvolvidos em Java com JUnit e Selenium.

## Tecnologias Utilizadas

- **Java**: Versão 11;
- **Selenium**: Para automação de navegadores;
- **JUnit**: Para execução de testes;
- **Maven**: Para gerenciamento de dependências.

## Testes desenvolvidos

No projeto, foram automatizadas as seguintes funcionalidades com os tipos de testes:

✅ **Login**
- Login com sucesso
- Falha no login
- Obrigatoriedade dos campos

✅ **Contas**
- Cadastro válido
- Cadastro inválido
- Edição e exclusão

✅ **Movimentações**
- Cadastro válido
- Cadastro inválido
- Exclusão

✅ **Resumo mensal**
- Consulta de movimentação mensal
- Exclusão

## Instalação

### Pré-requisitos

1. Instalar uma IDE de sua escolha, durante o desenvolvimento eu utilizei o Inteliji Community, que pode ser baixado acessando o [link](https://www.jetbrains.com/pt-br/idea/download/download-thanks.html?platform=windows&code=IIC);
2. Instalar a versão 11 do java no seguinte [link](https://www.azul.com/downloads/?version=java-11-lts&package=jdk#zulu);
3. Instalar o Git na máquina local;

### Clone do Repositório

1. Abrir o terminal (CMD)
2. Criar uma pasta de sua escolha
3. Rodar o seguinte comando ```Git clone https://github.com/AnaStadelhofer/A-SrBarrigaJava.git```

## Estrutura do Projeto

Aqui, uma breve descrição da estrutura do projeto:
```
/A-SrBarrigaJava
├── src
│   ├── main
│   │   └── java
│   │       └── br.com.barriga
│   │           └── core
│   │           └── page
│   └── test
│       └── java
│           └── br.com.barriga
│               └── suites
│               └── test
└── pom.xml
```
Dentro da pasta **main**, terá os arquivos que são responsáveis pela configuração do projeto, tais como o core e a page:

1. **core:** contém a configuração do projeto, tais como o driver do navegador, a página de instancia das pageobjects e também as basepage que foram feitas para heranças;
2. **page:** nesta pasta, irá conter todas as pageobject de cada página que foi criada nos testes, como: LoginPage, AccountPage e MovementPage.

Dentro da pasta **test**, terá os arquivos responsáveis pelo teste da aplicação:

1. **suites:** responsável pela execução em lote dos testes configurados;
2. **test:** arquivos com os testes que foram desenvolvidos. 

Após rodar os testes desejados, pode rodar o comando ```taskkill /F /IM chromedriver.exe /T``` no terminal, ele é responsável por finalizar as instancias do chrome driver que foram geradas.

Por padrão todos os testes executados não fecharão o navegador aberto, mas caso queira alterar, apenas mudar o valor da variável ```closeBrowser``` para True.

⚠️ **Aviso!** Este projeto foi configurado apenas para rodar no Chrome.

# Autor

**Linkedin:** [Ana Carolina Stadelhofer](https://www.linkedin.com/in/ana-carolina-stadelhofer/) 

**GitHub:** [Ana Stadelhofer](https://github.com/AnaStadelhofer/)

