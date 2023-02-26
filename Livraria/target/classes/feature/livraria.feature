# language: pt
@Livraria
Funcionalidade: Testar funcionalidades da Livraria

@001
Cenário: Não deve conseguir criar um usuário
Dado que acesso o site "https://demoqa.com/login"
Quando desejo criar um novo usuário
E digito o nome "José"
E digito o sobrenome "Cavalcanti"
E digito o userName "josecristovao"
E digito o password "12345"
E clico no botão register
Então o sistema apresenta a mensagem de erro "Please verify reCaptcha to register!"

@002
Cenário: Deve adicionar livro a sua coleção
Dado que acesso o site "https://demoqa.com/login"
Quando digito os dados do login
E digito o userName "josecristovao"
E digito o password "@Brasil123"
E clico no botão login
E clico no botão go to store
E digito o nome do livro "Git Pocket Guide"
E clico no livro desejado "Git Pocket Guide"
E faço a validação do ISBN do livro "9781449325862"
E faço a validação do nome do autor do livro "Richard E. Silverman"
E adiciono o livro a minha coleção
E aperto botão ok e valido mensagem popUp "Book added to your collection."
E vou para página inicial do meu perfil
Então verifico se o livro correto foi adicionado com sucesso "Git Pocket Guide"
Então verifico se o autor correto foi adicionado com sucesso "Richard E. Silverman"