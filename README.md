# Balanceamento de Árvore de Pesquisa

# Instruções e Objetivo

O objetivo deste trabalho, que deve ser feito em DUPLA, é o estudo, o entendimento e a implementação do balanceamento em árvores binárias de pesquisa, com base no critério de árvores AVL. Cada dupla deverá fazer todas as tarefas solicitadas a seguir conforme as orientações.

# Escolha da dupla
A primeira etapa do trabalho consiste na escolha da dupla. Os alunos devem se organizar em duplas e indicar os componentes da dupla na atividade de auto-seleção de grupos do Moodle criado para esta finalidade até o dia 15 de junho. Esta atividade está posicionada no card TDE abaixo do item “Trabalho 3”.

# Descrição
Após a definição da dupla, deverá ser feito um estudo do funcionamento da árvore de pesquisa AVL. A ideia é criar árvores através da inserção de nodos (método add), como no exemplo a seguir. Antes e depois do processo de balanceamento, devem ser chamados o método de caminhamento central.
 
 ABP B;
 
 B.add(10);
 
 B.add(6);
 
 B.add(12);
 
 B.add(11);
 
  for(int i=15;i<25;i++)
 
 B.add(i);
 
 B.GeraDOT();
 
 B.ApplyBalancing();
 
 B.GeraDOT();
 
Além de testar a árvore com o caminhamento central, o programa deve chamar o método GeraDot que gera o arquivo no formato DOT, do GraphViz, conforme visto em aula. Este arquivo permite a exibição das árvores através de ferramentas como:

• https://dreampuf.github.io/GraphvizOnline

• http://www.webgraphviz.com/

• http://viz-js.com/

# Elaboração do Trabalho
O desenvolvimento do trabalho consta das seguintes etapas:
  1. Estudar a árvore de pesquisa AVL;
  2. Implementar a árvore de acordo com a interface fornecida;
  3. Testar a árvore de pesquisa implementada de acordo com as instruções fornecidas.
O conteúdo pode ser encontrado nos livros indicados na bibliografia da disciplina, lembrando que o livro "Estruturas de dados e algoritmos em Java", de Goodrich e Tamassia (2013), está disponível online e aborda este conteúdo. Em C++, o livro "Data structure and algorithms using C++: a practical implementation", de Mohanty e Tripathy (2021), também está disponível online e aborda este conteúdo. Pesquisas na Web em sites confiáveis, tais como sites de universidades, podem ajudar no entendimento do conteúdo.

Após o entendimento do funcionamento da árvore AVL, é preciso implementá-la conforme o código disponível no Moodle. Portanto, deve ser implementada uma árvore de pesquisa para armazenar números inteiros usando o código passado e incluindo também os seguintes métodos:
  
  • applyBalancing(): para fazer o balanceamento da árvore;
  
  • isBalanced(): que retorna verdadeiro se a árvore está balanceada e falso caso contrário.

Para que os métodos listados acima funcionem, será necessário incluir outros métodos. Além da implementação da classe da árvore, é preciso complementar o método main para instanciar a árvore implementada e chamar os novos métodos implementados para verificar o seu correto funcionamento, conforme o exemplo passado anteriormente.

# Tarefas:
  • Estudar e implementar a árvore de pesquisa;
  
  • Implementar um programa que permita testar a estrutura de dados e os algoritmos implementados;
  
  • Apresentar a solução proposta durante a aula do dia agendado para entrega do trabalho. Quem tiver alguma dificuldade para fazer esta apresentação, basta entrar em contato com o(a) professor(a) para ver alguma alternativa;
  
  • Entregar no Moodle um arquivo zip contendo apenas: os arquivos do código fonte (somente os .java, ou os .cpp e .h).
