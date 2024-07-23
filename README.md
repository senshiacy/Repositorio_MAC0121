# Repositorio_MAC0121
Repositório com exercícios de programação da disciplina de MAC0121, desenvolvidos com a linguagem JAVA

## Dependências
Os programas desenvolvidos nessa disciplina, se baseiam na biblioteca disponibilizada por Sedgewick e Wayne. O passo a passo para instalá-la está no [site](https://lift.cs.princeton.edu/java/linux/), mas, também segue escrito:

### 1. Instalação do Java

#### 1. Baixar o Instalador do Java:

1. Acesse o site oficial do Java:
  - Vá para a página de downloads do Java no site da [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
    
2. Escolha a versão do Java:
  - Na página de downloads, selecione a versão do Java que você deseja instalar (recomendo a versão mais recente do JDK - Java Development Kit).

3. Baixe o instalador:
  - Clique no link de download apropriado para o seu sistema operacional (Windows, macOS, Linux).
  - Aceite os termos de licença e inicie o download.

#### 2. Instalar o Java

##### Para Windows:

1. Execute o instalador:
  - Após o download, localize o arquivo baixado e clique duas vezes para executá-lo.

2. Siga as instruções do instalador:
  - Siga as instruções na tela para completar a instalação.
  - Normalmente, você pode aceitar as configurações padrão.

3. Configurar variáveis de ambiente:
  - Após a instalação, você precisará configurar as variáveis de ambiente.
  - Abra o Painel de Controle e vá para **Sistema e Segurança > Sistema > Configurações avançadas do sistema > Variáveis de Ambiente**.
  - Na seção "Variáveis do sistema", clique em "Novo" e adicione uma nova variável chamada **`JAVA_HOME`** com o caminho para o diretório de instalação do JDK (exemplo: **`C:\Program Files\Java\jdk-17`**).
  - Encontre a variável **`Path`**, selecione-a e clique em "Editar". Adicione o caminho **`C:\Program Files\Java\jdk-17\bin`** ao final da lista.

##### Para macOS:

1. Execute o instalador:
  - Clique duas vezes no arquivo baixado (**`.dmg`**) para montá-lo.
  - Abra o instalador e siga as instruções na tela.

2. Verificar a instalação:
  - Abra o Terminal e digite java -version. Você deve ver a versão do Java instalada.
  - Para configurar JAVA_HOME, adicione a seguinte linha ao seu arquivo **`~/.bash_profile`** ou **`~/.zshrc`** (dependendo do shell que você usa):
    
```sh
export JAVA_HOME=$(/usr/libexec/java_home)
```

##### Para Linux:

1. Instalar via pacote:
  - Em distribuições baseadas no Debian (como Ubuntu), use:

```sh
sudo apt update
sudo apt install openjdk-17-jdk
```

  - Em distribuições baseadas no Red Hat (como Fedora), use:
    
```sh
sudo dnf install java-17-openjdk-devel
```

2. Configurar variáveis de ambiente:
  - Adicione as seguintes linhas ao seu arquivo ~/.bashrc ou ~/.zshrc:

```sh
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH
```

  - Após salvar o arquivo, atualize o shell com:

```sh
source ~/.bashrc
```

#### 3. Verificar a Instalação:

1. Verificar a versão do Java:
  - Abra um terminal ou prompt de comando.
  - Digite para verificar se a instalação foi bem-sucedida.
```sh
java -version
javac -version
```

### 2. Instalação da Biblioteca

Além da Biblioteca de Sedgewick e Wayne, vamos instalar *SpotBugs*, *PMD* e *Checkstyle* a ```/usr/local/lift``` e associá-los a scripts wrapper a ```/usr/local/bin```.

- Digite os seguintes comandos:
```sh
~$ cd /usr/local 
/usr/local~ sudo curl -O "https://lift.cs.princeton.edu/java/linux/lift-cli.zip"
/usr/local~ sudo unzip lift-cli.zip
/usr/local~ sudo rm lift-cli.zip
```

> O comando ```curl``` baixa arquivos da internet

- Para confirmar que tudo foi devidamente instalado, digite a linha de código

```sh
~$ java-introcs StdAudio
```

> Você deve ouvir uma sequência de sons.

Você não precisa atualizar nenhum arquivo de configuração do shell (como tal como o ```.bashrc```) ou definir qualquer Variáveis de ambiente (tais como ```JAVA_HOME``` ou ```CLASSPATH```). Para referência, aqui estão nossos arquivos de configuração de shell recomendados para Bash:
  - .bashrc
  - .bash_profile
  - .inputrc
