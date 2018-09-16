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


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: pokemon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pokemon (
    id integer NOT NULL,
    nom text,
    poids double precision,
    description text,
    idTypePokemon integer
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
-- Name: typePokemon; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.typePokemon (
    id integer NOT NULL,
    libelle text
);


ALTER TABLE public.typePokemon OWNER TO postgres;

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

ALTER SEQUENCE public.type_id_seq OWNED BY public.typePokemon.id;


--
-- Name: pokemon id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon ALTER COLUMN id SET DEFAULT nextval('public.pokemon_id_seq'::regclass);


--
-- Name: typePokemon id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typePokemon ALTER COLUMN id SET DEFAULT nextval('public.type_id_seq'::regclass);


--
-- Data for Name: pokemon; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pokemon VALUES (1, 'Bulbizarre', 6.9, 'Il y a une graine sur son dos. Il absorbe les rayons du soleil pour faire doucement pousser la graine.', 4);
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



--
-- Data for Name: typePokemon; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.typePokemon VALUES (1, 'Normal');
INSERT INTO public.typePokemon VALUES (2, 'Feu');
INSERT INTO public.typePokemon VALUES (3, 'Eau');
INSERT INTO public.typePokemon VALUES (4, 'Plante');
INSERT INTO public.typePokemon VALUES (5, 'Électrik');
INSERT INTO public.typePokemon VALUES (6, 'Glace');
INSERT INTO public.typePokemon VALUES (7, 'Combat');
INSERT INTO public.typePokemon VALUES (8, 'Poison');
INSERT INTO public.typePokemon VALUES (9, 'Sol');
INSERT INTO public.typePokemon VALUES (10, 'Vol');
INSERT INTO public.typePokemon VALUES (11, 'Psy');
INSERT INTO public.typePokemon VALUES (12, 'Insect');
INSERT INTO public.typePokemon VALUES (13, 'Roche');
INSERT INTO public.typePokemon VALUES (14, 'Spectre');
INSERT INTO public.typePokemon VALUES (15, 'Dragon');
INSERT INTO public.typePokemon VALUES (16, 'Ténèbre');
INSERT INTO public.typePokemon VALUES (17, 'Acier');


--
-- Name: pokemon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pokemon_id_seq', 26, true);


--
-- Name: type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.type_id_seq', 17, true);


--
-- Name: pokemon pokemon_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon
    ADD CONSTRAINT pokemon_pkey PRIMARY KEY (id);


--
-- Name: typePokemon type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typePokemon
    ADD CONSTRAINT type_pkey PRIMARY KEY (id);


--
-- Name: fki_one_type_to_many_pokemon; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_one_type_to_many_pokemon ON public.pokemon USING btree (idTypePokemon);


--
-- Name: pokemon one_type_to_many_pokemon; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon
    ADD CONSTRAINT one_type_to_many_pokemon FOREIGN KEY (idTypePokemon) REFERENCES public.typePokemon(id);


--
-- PostgreSQL database dump complete
--

