import requests
import psycopg2
from psycopg2 import sql

# Chave da API OMDB
OMDB_API_KEY = '2f9ca34e'
OMDB_API_URL = 'http://www.omdbapi.com/'

# Função para buscar detalhes de um filme pela API OMDB
def fetch_movie_details(title):
    params = {
        't': title,
        'apikey': OMDB_API_KEY
    }
    response = requests.get(OMDB_API_URL, params=params)

    if response.status_code == 200:
        movie_data = response.json()
        if movie_data['Response'] == 'True':
            return {
                'title': movie_data.get('Title', 'N/A'),
                'genre': movie_data.get('Genre', 'N/A'),
                'year': movie_data.get('Year', 'N/A'),
                'quantity': 5  # Valor padrão para quantidade disponível
            }
        else:
            print(f"Erro na busca pelo título {title}: {movie_data.get('Error')}")
    else:
        print(f"Erro na requisição: {response.status_code}")
    return None

# Função para conectar ao banco de dados PostgreSQL
def connect_db():
    try:
        connection = psycopg2.connect(
            host="localhost",  # ou o endereço do servidor do banco de dados
            database="cineloca-db",  # nome do banco de dados
            user="postgres",  # usuário do banco de dados
            password="1234"  # senha do banco de dados
        )
        return connection
    except Exception as error:
        print(f"Erro ao conectar ao banco de dados: {error}")
        return None

# Função para inserir um DVD no banco de dados
def insert_dvd(connection, dvd_data):
    try:
        cursor = connection.cursor()
        insert_query = """
        INSERT INTO dvds (titulo, genero, ano_lancamento, quantidade_disponivel)
        VALUES (%s, %s, %s, %s);
        """
        cursor.execute(insert_query, (dvd_data['title'], dvd_data['genre'], dvd_data['year'], dvd_data['quantity']))
        connection.commit()
        print(f"DVD '{dvd_data['title']}' inserido com sucesso!")
    except Exception as error:
        print(f"Erro ao inserir DVD: {error}")
        connection.rollback()

# Função principal para buscar e popular a tabela de DVDs
def populate_dvd_table(movie_titles):
    connection = connect_db()
    if connection is None:
        return

    for title in movie_titles:
        movie_details = fetch_movie_details(title)
        if movie_details:
            insert_dvd(connection, movie_details)

    connection.close()

# Lista de títulos de filmes que você deseja buscar na OMDB e inserir no banco
movies_to_add = [
    "The Matrix",
    "Inception",
    "Interstellar",
    "The Dark Knight",
    "Pulp Fiction"
]

# Popular o banco de dados com os filmes da lista
populate_dvd_table(movies_to_add)