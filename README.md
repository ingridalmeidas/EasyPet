# EasyPet

EasyPet é um aplicativo para adoção de animais, seu objetivo é que usuários possam procurar animais para adotar com base em suas caraterísticas ou cadastrar animais para que outros possam adotar. Essa é uma versão inicial desenvolvida como projeto para a disciplina de Métodos de Projeto de Software.

Obs: Para acessar o painel administrativo é necessário utilizar o login "admin" e a senha "admin".

# Grupo
Ingrid Luana - 11504745
Luiz Fernando - 11502754
Valfredo Santos - 11504304

# Padrões de Projeto

# DAO

O padrão DAO foi aplicado no package infra para servir como um intermediário entre as classes de gerência e os dados, que nesse caso utilizamos um sistema de arquivo. Esse padrão é importante pois permite que caso o sistema de arquivo fosse substituido por um banco de dados, era necessário apenas atualizar os métodos das classes DAO para que a aplicação voltasse a funcionar normalmente.

# Singleton

Singleton foi aplicado nas classes GerenciaUsuario, GerenciaAnimal e GerenciaDoacao para que apenas uma instância dessas classes possam ser criadas durante a execução do projeto, já que a criação de mais de um gerente dessas entidades poderiam afetar o funcionamento esperado da aplicação.

# Facade

O padrão Facade foi aplicado no package view para servir como uma interface que junta os diferentes métodos de outras classes, neste caso juntando métodos das três classes de gerência do package control e também alguns métodos da classe Menu. A junção desses métodos são feitas de tal forma que a classe Interface precisa apenas criar um objeto da classe Facade e executar as operações do programa a partir dele.

# Template Method

O template method foi utilizado para tratar os dois diferentes tipos de relatórios gerados pelos administradores, um relatório em XML e outro em PDF. O programa simula a chamada dos dois métodos dependendo da opção escolhida.

# Adapter

O adapter foi utilizado como um intermediário entre a aplicação e a API para validação de logins do Facebook e o Gmail, de forma que caso a API seja atualizada e alterada, basta que uma adaptação seja feita na classe adapter para que o sistema volte a funcionar normalmente.
