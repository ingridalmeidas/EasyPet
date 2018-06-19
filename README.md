# EasyPet

EasyPet é um aplicativo para adoção de animais, seu objetivo é que usuários possam procurar animais para adotar com base em suas caraterísticas ou cadastrar animais para que outros possam adotar. Essa é uma versão inicial desenvolvida como projeto para a disciplina de Métodos de Projeto de Software.

Obs: Para acessar o painel administrativo é necessário utilizar o login "admin" e a senha "admin".

# Grupo
Ingrid Luana - 11504745

Luiz Fernando - 11502754

Valfredo Santos - 11504304

# Padrões Aplicados

# DAO

O padrão DAO foi aplicado no package infra para servir como um intermediário entre as classes de gerência (GerenciaUsuario, GerenciaAnimal, GerenciaAdocao) e os dados, que nesse caso utilizamos um sistema de arquivo. Esse padrão é importante pois permite que caso o sistema de arquivo fosse substituido por um banco de dados, era necessário apenas atualizar os métodos das classes DAO para que a aplicação voltasse a funcionar normalmente.

# Singleton

O padrão singleton foi aplicado nas classes GerenciaUsuario, GerenciaAnimal e GerenciaDoacao para que apenas uma instância dessas classes possam ser criadas durante a execução do projeto, já que a criação de mais de um gerente dessas entidades poderiam afetar o funcionamento esperado da aplicação.

# Facade

O padrão Facade foi aplicado no package view para servir como uma interface que junta os diferentes métodos de outras classes, neste caso juntando métodos das três classes de gerência do package control e também os métodos da classe Menu. A junção desses métodos são feitas de tal forma que a classe Interface precisa apenas criar um objeto da classe Facade e executar as operações do programa a partir dele.

# Template Method

O padrão template method foi utilizado para tratar os dois diferentes tipos de relatórios gerados pelos administradores, um relatório em XML e outro em PDF. O programa simula a chamada dos dois métodos dependendo da opção escolhida.

# Adapter

O padrão adapter foi utilizado como um intermediário entre a aplicação e a API para validação de logins do Facebook e o Gmail, de forma que caso a API seja atualizada e alterada, basta que uma adaptação seja feita na classe adapter para que o sistema volte a funcionar normalmente.

# Memento

O padrão memento foi utilizado na classe GerenciaUsuario, foi criada uma classe GerenciaUsuarioCareTaker que mantém o estado anterior da lista de usuários, de forma que quando o programa insere ou remove um usuário, o memento pode ser utilizado para recuperar o estado anterior da lista onde aquele usuário ainda não foi inserido/removido.

# Command

O padrão command foi utilizado para implementar os diferentes tipos de notificações existentes na aplicação (por SMS ou Email), que são utilizados para a GerenciaAnimal enviar mensagens para o doador de um animal que alguém teve interesse em seu animal.
