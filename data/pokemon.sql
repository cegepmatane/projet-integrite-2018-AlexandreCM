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
-- Name: checksumnoms(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.checksumnoms() RETURNS text
    LANGUAGE sql
    AS $$
	SELECT MD5(string_agg(nom,'-')) as checksumNoms FROM pokemon
$$;


ALTER FUNCTION public.checksumnoms() OWNER TO postgres;

--
-- Name: effacertype(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.effacertype() RETURNS trigger
    LANGUAGE plpgsql
    AS $$

	
BEGIN
	DELETE FROM pokemon WHERE idtypepokemon = OLD.id;
	
    return NEW;
END


$$;


ALTER FUNCTION public.effacertype() OWNER TO postgres;

--
-- Name: journaliser(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.journaliser() RETURNS trigger
    LANGUAGE plpgsql
    AS $$



DECLARE 

    objetAvant text;

    objetApres text;

    operation text;

	

BEGIN

	objetAvant := '{}';

	objetApres := '{}';

	

	IF TG_OP = 'INSERT' THEN

   		objetApres := '{'||NEW.nom||', '||NEW.poids||', '||NEW.description||', '||NEW.idTypePokemon||'}';

        operation := 'AJOUTER';

    END IF;

	IF TG_OP = 'UPDATE' THEN

     	objetAvant := '{'||OLD.nom||', '||OLD.poids||', '||OLD.description||', '||OLD.idTypePokemon||'}';

    	objetApres := '{'||NEW.nom||', '||NEW.poids||', '||NEW.description||', '||NEW.idTypePokemon||'}';

        operation := 'MODIFIER';

    END IF;

	IF TG_OP = 'DELETE' THEN

    	objetAvant := '{'||OLD.nom||', '||OLD.poids||', '||OLD.description||', '||OLD.idTypePokemon||'}';

        operation := 'EFFACER';

    END IF;

	

 	INSERT into journal(moment, operation, ancienobjet, nouvelobjet) VALUES(NOW(), operation, objetAvant, objetApres);

	

	IF TG_OP = 'DELETE' THEN

		return OLD;

	END IF; 

	

    return NEW;

END



$$;


ALTER FUNCTION public.journaliser() OWNER TO postgres;

--
-- Name: maxpoidspokemon(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.maxpoidspokemon() RETURNS double precision
    LANGUAGE sql
    AS $$
	select max(poids) as maxPoidsPokemon from pokemon
$$;


ALTER FUNCTION public.maxpoidspokemon() OWNER TO postgres;

--
-- Name: minpoidspokemon(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.minpoidspokemon() RETURNS double precision
    LANGUAGE sql
    AS $$
	select min(poids) as minPoidsPokemon from pokemon
$$;


ALTER FUNCTION public.minpoidspokemon() OWNER TO postgres;

--
-- Name: moyennepoidspokemon(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.moyennepoidspokemon() RETURNS double precision
    LANGUAGE sql
    AS $$
	select avg(poids) as moyennePoidsPokemon from pokemon
$$;


ALTER FUNCTION public.moyennepoidspokemon() OWNER TO postgres;

--
-- Name: nombrepokemon(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.nombrepokemon() RETURNS bigint
    LANGUAGE sql
    AS $$
	select count(id) as nombrePokemon from pokemon
$$;


ALTER FUNCTION public.nombrepokemon() OWNER TO postgres;

--
-- Name: sommepoidspokemon(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION public.sommepoidspokemon() RETURNS double precision
    LANGUAGE sql
    AS $$
	select sum(poids) as sommePoidsPokemon from pokemon
$$;


ALTER FUNCTION public.sommepoidspokemon() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: journal; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.journal (
    id integer NOT NULL,
    moment time(6) with time zone NOT NULL,
    operation text NOT NULL,
    ancienobjet text NOT NULL,
    nouvelobjet text NOT NULL
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

INSERT INTO public.journal VALUES (1, '21:23:16.305583-04', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (2, '21:25:03.548069-04', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (3, '21:40:27.082386-04', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (4, '21:40:48.294058-04', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (5, '21:44:53.629097-04', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (6, '21:45:05.716014-04', 'Ajouter', 'pokemon', '{pika, electric}');
INSERT INTO public.journal VALUES (7, '21:52:58.281433-04', 'Ajouter', '{raikou}', 'pokemon');
INSERT INTO public.journal VALUES (8, '22:29:17.258026-04', 'AJOUTER', '{}', '{suicune,20.2,Vent du nord,4}');
INSERT INTO public.journal VALUES (9, '22:31:15.394991-04', 'AJOUTER', '{}', '{Entei, 25.1, Lion du feu, 2}');
INSERT INTO public.journal VALUES (10, '22:34:55.592769-04', 'MODIFIER', '{suicune, 20.2, Vent du nord, 4}', '{suicune, 20.2, Vent du nord, 3}');
INSERT INTO public.journal VALUES (11, '22:36:18.495813-04', 'EFFACER', '{Entei, 25.1, Lion du feu, 2}', '{}');
INSERT INTO public.journal VALUES (13, '22:51:51.445466-04', 'AJOUTER', '{}', '{test, 20, cest un test, 1}');
INSERT INTO public.journal VALUES (14, '22:53:57.610647-04', 'MODIFIER', '{test, 20, cest un test, 1}', '{test2, 20, cest un autre test, 1}');
INSERT INTO public.journal VALUES (15, '22:54:52.470914-04', 'EFFACER', '{test2, 20, cest un autre test, 1}', '{}');
INSERT INTO public.journal VALUES (16, '09:49:53.065551-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (17, '09:50:00.266202-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (18, '09:50:01.118535-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (19, '09:50:02.115107-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (20, '09:50:02.902312-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (21, '09:50:03.617391-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (22, '09:50:04.366999-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (23, '09:50:04.693563-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (24, '09:50:05.401375-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (25, '09:50:06.205759-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (26, '09:50:06.971421-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (27, '09:50:07.62528-04', 'AJOUTER', '{}', '{test, 2, desc, 1}');
INSERT INTO public.journal VALUES (28, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (29, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (30, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (31, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (32, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (33, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (34, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (35, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (36, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (37, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (38, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (39, '09:51:28.475293-04', 'EFFACER', '{test, 2, desc, 1}', '{}');
INSERT INTO public.journal VALUES (40, '10:01:48.974347-04', 'AJOUTER', '{}', '{gloubi, 2, no pokemon, 1}');
INSERT INTO public.journal VALUES (41, '10:01:51.34261-04', 'AJOUTER', '{}', '{gloubi, 2, no pokemon, 1}');
INSERT INTO public.journal VALUES (42, '10:01:51.70009-04', 'AJOUTER', '{}', '{gloubi, 2, no pokemon, 1}');
INSERT INTO public.journal VALUES (43, '10:01:52.098601-04', 'AJOUTER', '{}', '{gloubi, 2, no pokemon, 1}');
INSERT INTO public.journal VALUES (44, '10:01:52.432393-04', 'AJOUTER', '{}', '{gloubi, 2, no pokemon, 1}');
INSERT INTO public.journal VALUES (45, '10:01:52.913432-04', 'AJOUTER', '{}', '{gloubi, 2, no pokemon, 1}');
INSERT INTO public.journal VALUES (46, '10:01:53.192095-04', 'AJOUTER', '{}', '{gloubi, 2, no pokemon, 1}');
INSERT INTO public.journal VALUES (47, '10:01:53.608944-04', 'AJOUTER', '{}', '{gloubi, 2, no pokemon, 1}');
INSERT INTO public.journal VALUES (48, '10:03:22.040001-04', 'EFFACER', '{gloubi, 2, no pokemon, 1}', '{}');
INSERT INTO public.journal VALUES (49, '10:03:22.040001-04', 'EFFACER', '{gloubi, 2, no pokemon, 1}', '{}');
INSERT INTO public.journal VALUES (50, '10:03:22.040001-04', 'EFFACER', '{gloubi, 2, no pokemon, 1}', '{}');
INSERT INTO public.journal VALUES (51, '10:03:22.040001-04', 'EFFACER', '{gloubi, 2, no pokemon, 1}', '{}');
INSERT INTO public.journal VALUES (52, '10:03:22.040001-04', 'EFFACER', '{gloubi, 2, no pokemon, 1}', '{}');
INSERT INTO public.journal VALUES (53, '10:03:22.040001-04', 'EFFACER', '{gloubi, 2, no pokemon, 1}', '{}');
INSERT INTO public.journal VALUES (54, '10:03:22.040001-04', 'EFFACER', '{gloubi, 2, no pokemon, 1}', '{}');
INSERT INTO public.journal VALUES (55, '10:03:22.040001-04', 'EFFACER', '{gloubi, 2, no pokemon, 1}', '{}');


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
INSERT INTO public.pokemon VALUES (38, 'suicune', 20.199999999999999, 'Vent du nord', 3);


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

SELECT pg_catalog.setval('public.journal_id_seq', 55, true);


--
-- Name: pokemon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pokemon_id_seq', 61, true);


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
-- Name: pokemon evenementeffacerpokemon; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementeffacerpokemon BEFORE DELETE ON public.pokemon FOR EACH ROW EXECUTE PROCEDURE public.journaliser();


--
-- Name: typepokemon evenementeffacertypepokemon; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementeffacertypepokemon BEFORE DELETE ON public.typepokemon FOR EACH ROW EXECUTE PROCEDURE public.effacertype();


--
-- Name: pokemon evenementmodifierpokemon; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER evenementmodifierpokemon BEFORE UPDATE ON public.pokemon FOR EACH ROW EXECUTE PROCEDURE public.journaliser();


--
-- Name: pokemon one_type_to_many_pokemon; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon
    ADD CONSTRAINT one_type_to_many_pokemon FOREIGN KEY (idtypepokemon) REFERENCES public.typepokemon(id);


--
-- PostgreSQL database dump complete
--

