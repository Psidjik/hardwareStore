PGDMP     9    	                {            PD    15.3    15.3     !           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            "           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            #           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            $           1262    98591    PD    DATABASE     x   CREATE DATABASE "PD" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Europe.1251';
    DROP DATABASE "PD";
                postgres    false            �            1259    98592    category    TABLE     t   CREATE TABLE public.category (
    category_title character varying(255),
    id character varying(255) NOT NULL
);
    DROP TABLE public.category;
       public         heap    postgres    false            �            1259    98599    client    TABLE     �  CREATE TABLE public.client (
    is_active boolean NOT NULL,
    created timestamp(6) without time zone,
    modified timestamp(6) without time zone,
    first_name character varying(255),
    id character varying(255) NOT NULL,
    last_name character varying(255),
    password character varying(255),
    phone_number character varying(255),
    role_id character varying(255),
    username character varying(255)
);
    DROP TABLE public.client;
       public         heap    postgres    false            �            1259    98606    feedback    TABLE     *  CREATE TABLE public.feedback (
    rating integer,
    feedback_date timestamp(6) without time zone,
    client_id character varying(255),
    description character varying(255),
    id character varying(255) NOT NULL,
    image_url character varying(255),
    product_id character varying(255)
);
    DROP TABLE public.feedback;
       public         heap    postgres    false            �            1259    98613    orders    TABLE       CREATE TABLE public.orders (
    price double precision NOT NULL,
    created timestamp(6) without time zone,
    modified timestamp(6) without time zone,
    client_id character varying(255),
    id character varying(255) NOT NULL,
    product_id character varying(255)
);
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    98620    product    TABLE     �  CREATE TABLE public.product (
    count integer NOT NULL,
    price double precision NOT NULL,
    created timestamp(6) without time zone,
    modified timestamp(6) without time zone,
    article character varying(255),
    category_id character varying(255),
    description character varying(255),
    id character varying(255) NOT NULL,
    image_url character varying(255),
    product_title character varying(255)
);
    DROP TABLE public.product;
       public         heap    postgres    false            �            1259    98627    roles    TABLE     �   CREATE TABLE public.roles (
    name smallint,
    id character varying(255) NOT NULL,
    CONSTRAINT roles_name_check CHECK (((name >= 0) AND (name <= 1)))
);
    DROP TABLE public.roles;
       public         heap    postgres    false                      0    98592    category 
   TABLE DATA           6   COPY public.category (category_title, id) FROM stdin;
    public          postgres    false    214   A#                 0    98599    client 
   TABLE DATA           �   COPY public.client (is_active, created, modified, first_name, id, last_name, password, phone_number, role_id, username) FROM stdin;
    public          postgres    false    215   �#                 0    98606    feedback 
   TABLE DATA           l   COPY public.feedback (rating, feedback_date, client_id, description, id, image_url, product_id) FROM stdin;
    public          postgres    false    216   %                 0    98613    orders 
   TABLE DATA           U   COPY public.orders (price, created, modified, client_id, id, product_id) FROM stdin;
    public          postgres    false    217   �%                 0    98620    product 
   TABLE DATA           �   COPY public.product (count, price, created, modified, article, category_id, description, id, image_url, product_title) FROM stdin;
    public          postgres    false    218   N&                 0    98627    roles 
   TABLE DATA           )   COPY public.roles (name, id) FROM stdin;
    public          postgres    false    219   �*       z           2606    98598    category category_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public            postgres    false    214            |           2606    98605    client client_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    215            ~           2606    98612    feedback feedback_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.feedback
    ADD CONSTRAINT feedback_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.feedback DROP CONSTRAINT feedback_pkey;
       public            postgres    false    216            �           2606    98619    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    217            �           2606    98626    product product_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    218            �           2606    98632    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    219            �           2606    98648 "   orders fk17yo6gry2nuwg2erwhbaxqbs9    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk17yo6gry2nuwg2erwhbaxqbs9 FOREIGN KEY (client_id) REFERENCES public.client(id);
 L   ALTER TABLE ONLY public.orders DROP CONSTRAINT fk17yo6gry2nuwg2erwhbaxqbs9;
       public          postgres    false    217    215    3196            �           2606    98658 #   product fk1mtsbur82frn64de7balymq9s    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT fk1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id) REFERENCES public.category(id);
 M   ALTER TABLE ONLY public.product DROP CONSTRAINT fk1mtsbur82frn64de7balymq9s;
       public          postgres    false    218    3194    214            �           2606    98653 "   orders fk787ibr3guwp6xobrpbofnv7le    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT fk787ibr3guwp6xobrpbofnv7le FOREIGN KEY (product_id) REFERENCES public.product(id);
 L   ALTER TABLE ONLY public.orders DROP CONSTRAINT fk787ibr3guwp6xobrpbofnv7le;
       public          postgres    false    217    3202    218            �           2606    98638 $   feedback fk9rh73oafv80ggwri04l9223bi    FK CONSTRAINT     �   ALTER TABLE ONLY public.feedback
    ADD CONSTRAINT fk9rh73oafv80ggwri04l9223bi FOREIGN KEY (client_id) REFERENCES public.client(id);
 N   ALTER TABLE ONLY public.feedback DROP CONSTRAINT fk9rh73oafv80ggwri04l9223bi;
       public          postgres    false    215    3196    216            �           2606    98633 "   client fka5d3vului6frmr4wbf8pvgh2l    FK CONSTRAINT     �   ALTER TABLE ONLY public.client
    ADD CONSTRAINT fka5d3vului6frmr4wbf8pvgh2l FOREIGN KEY (role_id) REFERENCES public.roles(id);
 L   ALTER TABLE ONLY public.client DROP CONSTRAINT fka5d3vului6frmr4wbf8pvgh2l;
       public          postgres    false    215    219    3204            �           2606    98643 $   feedback fklsfunb44jdljfmbx4un8s4waa    FK CONSTRAINT     �   ALTER TABLE ONLY public.feedback
    ADD CONSTRAINT fklsfunb44jdljfmbx4un8s4waa FOREIGN KEY (product_id) REFERENCES public.product(id);
 N   ALTER TABLE ONLY public.feedback DROP CONSTRAINT fklsfunb44jdljfmbx4un8s4waa;
       public          postgres    false    216    218    3202               �   x�N��0|�U��E6��腏�:B�ă(��HQ�Z����F�9�NOZh�'Z�Li�����]L|�O�<��/C�-��4�LB)�
�����Ztt륯�7σr	:>�F���.h�e��#]���G����U�!jF�R�
L(��a'��B�Rx           x�}�;o�@�k�W��=k�^����$hh�,Ŗy%񿏃R��4��j盔��2�p��L h&�k�C,Y4���̈́�'7�n�0�Gy:n����Ҹjw�Y1��$���O���G�y�ׇ��6�;%��%�d"2Y:��ᖑ6�j�\�\��&�d�`��;�C%� 
�L	�?ks�S*i#@0�����>�$�l��?<-+��l��n��{M���|���e�5Z/����i�G[�v#e�Ĭת�1��I�q2�	���"��oh`�         �   x���1 �I4���8��>q�ֱ,�$�����cFi�q�<�
'�hI(�d0l1{����S�Bs�r.R��b����>��W����:���[���ø�R�)BȞ�/�Aa��B�)��U���
b+�4ɼԃT̀�^��M��b���e:+         u   x�}�I�0�s������r��"o�!4z�ap	D���?�G��vKj�G�SC�4*�L�)��n;"��c��]�-Ԇڛ֢��h����|.ے��7�N��R��0����K)?	�'�         L  x��U�n�F>SO��h�]r�?~��-P�(���ʢ*�q�S��#|i/�����m�reɢ_a��$�YJ�].I����v�YG�SJ�:.aa�dt��MZL���21#���yNr?��" qe�gy���R71�oꅜ�����/�UoA^����cSʱ����r�������^S���ڔSP���-�5���)/�T^��G��j�g���D�~
�9H���݄`��r�6�z�t ^}�W��5fSGm�?щƲnc؉�2�s���Q�Eď���4vI�ЀИ�!M�<���SU��m'i�z>̊ް��f���{v�u���)�th��,���;xF����l����*�`���C�O� ��X���"U�dx���o���p��d�(;���4���"��7�i�!G�=�8�&g��<7������G��G�S��0�R�nP(�H�!�0MmG��/~1�9`�@�P��-���@Kձ�T/�{81�f!@~���N�;!a�}���f��F�~��SsN���>膔�<���&�X#�{��Є<o"�� ��iTG��������w��c<����M�kFC��	z�Qa-j9��[���,��2��̒�y¨)�2�ꎠ��X��,#�� �/¹/\ �pDHC��^x���lP�f�n�CJwwW�����2J���Y�!��x{8�N��Q�N��;eUä�-z�����h�*�;���a���if_?9�;O��~�W���������۰�`:�A��_��]~���X�r��~��b��,�����^\���3\n$2�$�܀pJ�	#��D覩=��&��)���^7{����g�L͕C=	�f�A����7z�uT\��4�p87�@:�k��cF�Yo�zmԚ�3�Mq��j�Qo��L�	�5��}�-y?YmX��k��������C�Jd����^�[�a�Z�V��{.�X��ao�dQ¹K��+�2z�%>K#?K<�����>VQU$�el��qǵ�A�)zQ���m�K�j�'�b����#��B��Fd'Mm��i��hY���0A[[V���S�%         K   x����  �w�8��K>r�	q��O�0)1v��-9{��9�z��Z]{5zL���8�$mDs|/ �n��     