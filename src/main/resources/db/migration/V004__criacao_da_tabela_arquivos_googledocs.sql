CREATE TABLE google_docs_files (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
	dt DATETIME NOT NULL,
    descricao VARCHAR(200) NOT NULL,
    prettyStr VARCHAR(200) NOT NULL,
    mimeType VARCHAR(200) NOT NULL
    
) ENGINE=InnoDB DEFAULT CHARSET=utf8;