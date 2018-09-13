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
    type integer
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
-- Name: type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.type (
    id integer NOT NULL,
    libelle text
);


ALTER TABLE public.type OWNER TO postgres;

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

ALTER SEQUENCE public.type_id_seq OWNED BY public.type.id;


--
-- Name: pokemon id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon ALTER COLUMN id SET DEFAULT nextval('public.pokemon_id_seq'::regclass);


--
-- Name: type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type ALTER COLUMN id SET DEFAULT nextval('public.type_id_seq'::regclass);


--
-- Data for Name: pokemon; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.pokemon VALUES (21, 'Piafabec', NULL, NULL, 10);
INSERT INTO public.pokemon VALUES (22, 'Rapasdepic', NULL, NULL, 10);
INSERT INTO public.pokemon VALUES (23, 'Abo', NULL, NULL, 8);
INSERT INTO public.pokemon VALUES (24, 'Arbok', NULL, NULL, 8);
INSERT INTO public.pokemon VALUES (10, 'Chenipan', NULL, NULL, 12);
INSERT INTO public.pokemon VALUES (12, 'Papilusion', NULL, NULL, 12);
INSERT INTO public.pokemon VALUES (11, 'Chrysacier', NULL, NULL, 12);
INSERT INTO public.pokemon VALUES (14, 'Coconfort', NULL, NULL, 12);
INSERT INTO public.pokemon VALUES (13, 'Aspicot', NULL, NULL, 12);
INSERT INTO public.pokemon VALUES (16, 'Roucool', NULL, NULL, 10);
INSERT INTO public.pokemon VALUES (15, 'Dardargnan', NULL, NULL, 12);
INSERT INTO public.pokemon VALUES (18, 'Roucarnage', NULL, NULL, 10);
INSERT INTO public.pokemon VALUES (17, 'Roucoups', NULL, NULL, 10);
INSERT INTO public.pokemon VALUES (20, 'Rattatac', NULL, NULL, 1);
INSERT INTO public.pokemon VALUES (19, 'Rattata', NULL, NULL, 1);
INSERT INTO public.pokemon VALUES (1, 'Bulbizarre', 6.9, 'Bulbizarre passe son temps à faire la sieste sous le soleil. Il y a une graine sur son dos. Il absorbe les rayons du soleil pour faire doucement pousser la graine.', 4);
INSERT INTO public.pokemon VALUES (2, 'Herbizarre', 12, 'Un bourgeon a poussé sur le dos de ce Pokémon. Pour en supporter le poids, Herbizarre a dû se muscler les pattes. Lorsqu’il commence à se prélasser au soleil, ça signifie que son bourgeon va éclore, donnant naissance à une fleur.', 4);
INSERT INTO public.pokemon VALUES (4, 'Salameche', 8.5, 'La flamme qui brûle au bout de sa queue indique l’humeur de ce Pokémon. Elle vacille lorsque Salamèche est content. En revanche, lorsqu’il s’énerve, la flamme prend de l’importance et brûle plus ardemment.', 2);
INSERT INTO public.pokemon VALUES (3, 'Florizarre', 155.5, 'Une belle fleur se trouve sur le dos de Florizarre. Elle prend une couleur vive lorsqu’elle est bien nourrie et bien ensoleillée. Le parfum de cette fleur peut apaiser les gens.', 4);
INSERT INTO public.pokemon VALUES (6, 'Dracaufeu', 90.5, 'Dracaufeu parcourt les cieux pour trouver des adversaires à sa mesure. Il crache de puissantes flammes capables de faire fondre n’importe quoi. Mais il ne dirige jamais son souffle destructeur vers un ennemi plus faible.', 2);
INSERT INTO public.pokemon VALUES (5, 'Reptincel', 19, 'Reptincel lacère ses ennemis sans pitié grâce à ses griffes acérées. S’il rencontre un ennemi puissant, il devient agressif et la flamme au bout de sa queue s’embrase et prend une couleur bleu clair.', 2);
INSERT INTO public.pokemon VALUES (9, 'Tortank', 85.5, 'Tortank dispose de canons à eau émergeant de sa carapace. Ils sont très précis et peuvent envoyer des balles d’eau capables de faire mouche sur une cible située à plus de 50 m.', 3);
INSERT INTO public.pokemon VALUES (8, 'Carabaffe', 22.5, 'Carabaffe a une large queue recouverte d’une épaisse fourrure. Elle devient de plus en plus foncée avec l’âge. Les éraflures sur la carapace de ce Pokémon témoignent de son expérience au combat.', 3);
INSERT INTO public.pokemon VALUES (7, 'Carapuce', 9, 'La carapace de Carapuce ne sert pas qu’à le protéger. La forme ronde de sa carapace et ses rainures lui permettent d’améliorer son hydrodynamisme. Ce Pokémon nage extrêmement vite.', 3);
INSERT INTO public.pokemon VALUES (25, 'Pikachu', 6, 'Un projet de centrale électrique fonctionnant en rassemblant une foule de Pikachu a été récemment annoncé.', 5);
INSERT INTO public.pokemon VALUES (26, 'Raichu', 30, 'Ce Pokémon peut accumuler jusqu’à 100 000 volts. Il peut ainsi assommer un éléphant juste en le touchant.', 5);


--
-- Data for Name: type; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.type VALUES (1, 'Normal');
INSERT INTO public.type VALUES (2, 'Feu');
INSERT INTO public.type VALUES (3, 'Eau');
INSERT INTO public.type VALUES (4, 'Plante');
INSERT INTO public.type VALUES (5, 'Électrik');
INSERT INTO public.type VALUES (6, 'Glace');
INSERT INTO public.type VALUES (7, 'Combat');
INSERT INTO public.type VALUES (8, 'Poison');
INSERT INTO public.type VALUES (9, 'Sol');
INSERT INTO public.type VALUES (10, 'Vol');
INSERT INTO public.type VALUES (11, 'Psy');
INSERT INTO public.type VALUES (12, 'Insect');
INSERT INTO public.type VALUES (13, 'Roche');
INSERT INTO public.type VALUES (14, 'Spectre');
INSERT INTO public.type VALUES (15, 'Dragon');
INSERT INTO public.type VALUES (16, 'Ténèbre');
INSERT INTO public.type VALUES (17, 'Acier');


--
-- Name: pokemon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pokemon_id_seq', 1, false);


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
-- Name: type type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.type
    ADD CONSTRAINT type_pkey PRIMARY KEY (id);


--
-- Name: fki_one_type_to_many_pokemon; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_one_type_to_many_pokemon ON public.pokemon USING btree (type);


--
-- Name: pokemon one_type_to_many_pokemon; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pokemon
    ADD CONSTRAINT one_type_to_many_pokemon FOREIGN KEY (type) REFERENCES public.type(id);


--
-- PostgreSQL database dump complete
--

