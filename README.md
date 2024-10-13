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

# Sobre mim
<a href="https://www.linkedin.com/in/ana-carolina-stadelhofer/">
 <img style="border-radius: 50%;" src="https://media.licdn.com/dms/image/v2/D4D03AQGAQ-VkazPtBQ/profile-displayphoto-shrink_800_800/profile-displayphoto-shrink_800_800/0/1724111439720?e=1734566400&v=beta&t=XcY8U0V65N6rf-KU8YqQvLX2xSK7rB8w4lcSIfp72Cs" width="100px;" alt=""/>
 <br />
<b>Ana Carolina Stadelhofer</b>
 
Sou Analista de Qualidade e Testes, atuando na área desde 2021. Formada em Análise e Desenvolvimento de Sistema e Pós-graduada em Testes de Software.
Costantemente estou em busca de conhecimento! Acesse meu [Linkedin](https://www.linkedin.com/in/ana-carolina-stadelhofer/) e conecte-se comigo!

Feito com carinho por Ana Stadelhofer

[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ana-carolina-stadelhofer/)
[![Outlook](https://img.shields.io/badge/Microsoft_Outlook-0078D4?style=for-the-badge&logo=microsoft-outlook&logoColor=white)](mailto:ana.stadelhofer@outlook.com)
