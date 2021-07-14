## Sistema de cafeteria Starbuzz
Projeto para fins educativos ue exemplifica o uso do padrão decorator.cafeteria

## Problema

Quando foi desenhado o sistema a uns tempos atrás, a cafeteria ainda recebia pquenas quantidades de pedidos e
poucas opções de bebidas. Na primeira versão, o sistema foi desenhado assim:

![before](/docs/images/before-1.png)

Além de escolher o tipo do café, você também pode adicionar condimentos ao seu café, como chocolte, soja, leite, etc.
Foi criado então novos tipos de subclasses, para combinar os varios tipos de bebidas que o sistema possuia:

![before](/docs/images/before-2.png)

Perceba que o sistema acabou se tornando uma bomba relógio... E se quisermos adicionar uma cobertura de caramelo? Ou
quisermos aumentar o preço de um unico item? Ou ainda, se eu quiser cobertura extra? A manutenção e extensão acaba sendo muito custoso nesse caso.

**Designer principle: Classes should be open to extension, but closed for modification**

## Solução

O designer pattern decorator anexa novas responsabilidades ao obbjeto dinamicamente. Os decorators provê uma
funcionalidade alternativa para subclasses por extender funcionalidade.

“Envoltório” (ing. “wrapper”) é o apelido alternativo para o padrão Decorator que expressa claramente a ideia principal dele.
Um envoltório é um objeto que pode ser ligado com outro objeto alvo. O envoltório contém o mesmo conjunto de métodos que o alvo e
delega a ele todos os pedidos que recebe. Contudo, o envoltório pode alterar o resultado fazendo alguma coisa ou antes ou
depois de passar o pedido para o alvo.

Quando um simples envoltório se torna um verdadeiro decorador? O envoltório implementa a mesma interface que o objeto envolvido.
É por isso que da perspectiva do cliente esses objetos são idênticos.
Faça o campo de referência do envoltório aceitar qualquer objeto que segue aquela interface.
Isso lhe permitirá cobrir um objeto em múltiplos envoltórios, adicionando o comportamento combinado de todos os envoltórios a ele.

No exemplo da cafeteria vamos deixar o simples comportamento de custo dentro da classe Bevarage mas
 transformar todos as opções de condimentos em decoradores.

![after](/docs/images/decorator-pattern.png)

## Aplicabilidade

- Utilize o padrão Decorator quando você precisa ser capaz de projetar comportamentos adicionais para objetos em tempo
de execução sem quebrar o código que usa esses objetos.
    - O Decorator lhe permite estruturar sua lógica de negócio
em camadas, criar um decorador para cada camada, e compor objetos com várias combinações dessa lógica durante a execução.
O código cliente pode tratar de todos esses objetos da mesma forma, como todos seguem a mesma interface comum.

- Utilize o padrão quando é complicado ou impossível estender o comportamento de um objeto usando herança.
    - Muitas linguagens de programação tem a palavra chave final que pode ser usada para prevenir a extensão de uma classe. Para uma classe final, a única maneira de reutilizar seu comportamento existente seria envolver a classe com seu próprio invólucro usando o padrão Decorator.

## Prós e contras

- Você pode estender o comportamento de um objeto sem fazer um nova subclasse.
- Você pode adicionar ou remover responsabilidades de um objeto no momento da execução.
- Você pode combinar diversos comportamentos ao envolver o objeto com múltiplos decoradores.
- Princípio de responsabilidade única. Você pode dividir uma classe monolítica que implementa muitas possíveis variantes de um comportamento em diversas classes menores.
- Maior número de classes utilizadas no projeto quando comparado com a versão que tinha somente mais atributos e métodos na classe base para a implementação das funcionalidades extras;
- Pode prejudicar a leitura e manutenção do projeto caso muitas classes a mais forem necessárias;


# Referências

- [Livro Head First Designer Pattern (Segunda edição)](https://www.amazon.com.br/Head-First-Design-Patterns-Object-Oriented/dp/149207800X/ref=pd_lpo_14_t_0/141-9002804-0455951?_encoding=UTF8&pd_rd_i=149207800X&pd_rd_r=4c8bc77f-fcdc-414a-bc7f-2532902e5165&pd_rd_w=ivF6F&pd_rd_wg=NhHaw&pf_rd_p=cfa1789c-e63b-406f-a502-2b3819ce5a27&pf_rd_r=BCQH9WMS7EK2PSEV5R1P&psc=1&refRID=BCQH9WMS7EK2PSEV5R1P)
- [Refactoring Guru website](https://refactoring.guru/pt-br/design-patterns/observer)