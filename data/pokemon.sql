--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: pokemon; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE pokemon WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_Canada.1252' LC_CTYPE = 'French_Canada.1252';


ALTER DATABASE pokemon OWNER TO postgres;

\connect pokemon

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: journaliser(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.journaliser() RETURNS trigger
    LANGUAGE plpgsql
    AS $$

DECLARE 
	description text;
	
BEGIN
	description := '{'|| NEW.nom ||'}';
	INSERT INTO journal(moment, operation, description, objet) VALUES (NOW(), 'Ajouter', description, 'pokemon');
	RETURN NEW;
END
$$;


ALTER FUNCTION public.journaliser() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.journal (
    id integer NOT NULL,
    moment time(6) without time zone NOT NULL,
    operation text NOT NULL,
    description text,
    objet text NOT NULL
);


ALTER TABLE public.journal OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.journal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.journal_id_seq OWNER TO postgres;

--
-- Name: journal_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.journal_id_seq OWNED BY public.journal.id;


--
-- Name: pokemon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pokemon (
    id integer NOT NULL,
    nom text,
    poids double precision,
    description text,
    idtypepokemon integer
);


ALTER TABLE public.pokemon OWNER TO postgres;

--
-- Name: pokemon_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pokemon_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pokemon_id_seq OWNER TO postgres;

--
-- Name: pokemon_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pokemon_id_seq OWNED BY public.pokemon.id;


--
-- Name: typepokemon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.typepokemon (
    id integer NOT NULL,
    libelle text
);


ALTER TABLE public.typepokemon OWNER TO postgres;

--
-- Name: type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.type_id_seq OWNER TO postgres;

--
-- Name: type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.type_id_seq OWNED BY public.typepokemon.id;


--
-- Name: journal id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal ALTER COLUMN id SET DEFAULT nextval('public.journal_id_seq'::regclass);


--
-- Name: pokemon id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon ALTER COLUMN id SET DEFAULT nextval('public.pokemon_id_seq'::regclass);


--
-- Name: typepokemon id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typepokemon ALTER COLUMN id SET DEFAULT nextval('public.type_id_seq'::regclass);


--
-- Data for Name: journal; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.journal VALUES (1, '21:23:16.305583', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (2, '21:25:03.548069', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (3, '21:40:27.082386', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (4, '21:40:48.294058', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (5, '21:44:53.629097', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (6, '21:45:05.716014', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (7, '21:52:58.281433', 'Ajouter', '{raikou}', 'pokemon');


--
-- Data for Name: pokemon; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pokemon VALUES (1, 'Bulbizarre', 6.9000000000000004, 'Il y a une graine sur son dos. Il absorbe les rayons du soleil pour faire doucement pousser la graine.', 4);
INSERT INTO public.pokemon VALUES (2, 'Herbizarre', 12, 'Un bourgeon a poussé sur le dos de ce Pokémon. Lorsqu’il commence à se prélasser au soleil, ça signifie que son bourgeon va éclore, donnant naissance à une fleur.', 4);
INSERT INTO public.pokemon VALUES (3, 'Florizarre', 155.5, 'Une belle fleur se trouve sur le dos de Florizarre. Le parfum de cette fleur peut apaiser les gens.', 4);
INSERT INTO public.pokemon VALUES (4, 'Salameche', 8.5, 'La flamme qui brûle au bout de sa queue indique l’humeur de ce Pokémon. Elle vacille lorsque Salamèche est content.', 2);
INSERT INTO public.pokemon VALUES (5, 'Reptincel', 19, 'S’il rencontre un ennemi puissant, il devient agressif et la flamme au bout de sa queue s’embrase et prend une couleur bleu clair.', 2);
INSERT INTO public.pokemon VALUES (6, 'Dracaufeu', 90.5, 'Dracaufeu parcourt les cieux pour trouver des adversaires à sa mesure.', 2);
INSERT INTO public.pokemon VALUES (7, 'Carapuce', 9, 'La forme ronde de sa carapace et ses rainures lui permettent d’améliorer son hydrodynamisme', 3);
INSERT INTO public.pokemon VALUES (8, 'Carabaffe', 22.5, 'Les éraflures sur la carapace de ce Pokémon témoignent de son expérience au combat.', 3);
INSERT INTO public.pokemon VALUES (9, 'Tortank', 85.5, 'Tortank dispose de canons à eau émergeant de sa carapace. Ils sont très précis et peuvent envoyer des balles d’eau capables de faire mouche sur une cible située à plus de 50 m.', 3);
INSERT INTO public.pokemon VALUES (25, 'Pikachu', 6, 'Un projet de centrale électrique fonctionnant en rassemblant une foule de Pikachu a été récemment annoncé.', 5);
INSERT INTO public.pokemon VALUES (26, 'Raichu', 30, 'Ce Pokémon peut accumuler jusqu’à 100 000 volts. Il peut ainsi assommer un éléphant juste en le touchant.', 5);
INSERT INTO public.pokemon VALUES (27, 'mew', NULL, NULL, NULL);
INSERT INTO public.pokemon VALUES (28, 'mewtoo', NULL, NULL, NULL);
INSERT INTO public.pokemon VALUES (30, 'raikou', NULL, NULL, NULL);


--
-- Data for Name: typepokemon; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.typepokemon VALUES (1, 'Normal');
INSERT INTO public.typepokemon VALUES (2, 'Feu');
INSERT INTO public.typepokemon VALUES (3, 'Eau');
INSERT INTO public.typepokemon VALUES (4, 'Plante');
INSERT INTO public.typepokemon VALUES (5, 'Électrik');
INSERT INTO public.typepokemon VALUES (6, 'Glace');
INSERT INTO public.typepokemon VALUES (7, 'Combat');
INSERT INTO public.typepokemon VALUES (8, 'Poison');
INSERT INTO public.typepokemon VALUES (9, 'Sol');
INSERT INTO public.typepokemon VALUES (10, 'Vol');
INSERT INTO public.typepokemon VALUES (11, 'Psy');
INSERT INTO public.typepokemon VALUES (12, 'Insect');
INSERT INTO public.typepokemon VALUES (13, 'Roche');
INSERT INTO public.typepokemon VALUES (14, 'Spectre');
INSERT INTO public.typepokemon VALUES (15, 'Dragon');
INSERT INTO public.typepokemon VALUES (16, 'Ténèbre');
INSERT INTO public.typepokemon VALUES (17, 'Acier');


--
-- Name: journal_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.journal_id_seq', 7, true);


--
-- Name: pokemon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pokemon_id_seq', 30, true);


--
-- Name: type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_id_seq', 17, true);


--
-- Name: journal journal_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.journal
    ADD CONSTRAINT journal_pkey PRIMARY KEY (id);


--
-- Name: pokemon pokemon_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon
    ADD CONSTRAINT pokemon_pkey PRIMARY KEY (id);


--
-- Name: typepokemon type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typepokemon
    ADD CONSTRAINT type_pkey PRIMARY KEY (id);


--
-- Name: fki_one_type_to_many_pokemon; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_one_type_to_many_pokemon ON public.pokemon USING btree (idtypepokemon);


--
-- Name: pokemon evenementajouterpokemon; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementajouterpokemon BEFORE INSERT ON public.pokemon FOR EACH ROW EXECUTE PROCEDURE public.journaliser();


--
-- Name: pokemon one_type_to_many_pokemon; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon
    ADD CONSTRAINT one_type_to_many_pokemon FOREIGN KEY (idtypepokemon) REFERENCES public.typepokemon(id);


--
-- PostgreSQL database dump complete
--

