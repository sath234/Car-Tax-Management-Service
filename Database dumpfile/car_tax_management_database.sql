PGDMP                         y           car_tax_management    13.1    13.1 '    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    30898    car_tax_management    DATABASE     _   CREATE DATABASE "car_tax_management" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';
 $   DROP DATABASE "car_tax_management";
                postgres    false            �            1259    33735    address    TABLE       CREATE TABLE "public"."address" (
    "adressid" integer NOT NULL,
    "country" character varying(255),
    "county" character varying(255),
    "nameornumber" character varying(255),
    "postcode" character varying(255),
    "street" character varying(255)
);
    DROP TABLE "public"."address";
       public         heap    postgres    false            �            1259    33733    address_adressid_seq    SEQUENCE     �   ALTER TABLE "public"."address" ALTER COLUMN "adressid" ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME "public"."address_adressid_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    201            �            1259    33745    car    TABLE     �   CREATE TABLE "public"."car" (
    "carid" integer NOT NULL,
    "fueltype" character varying(255),
    "numberplate" character varying(255),
    "vehiclecolour" character varying(255),
    "vehiclemake" character varying(255),
    "ownerid" integer
);
    DROP TABLE "public"."car";
       public         heap    postgres    false            �            1259    33743    car_carid_seq    SEQUENCE     �   ALTER TABLE "public"."car" ALTER COLUMN "carid" ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME "public"."car_carid_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    203            �            1259    33755    owner    TABLE     
  CREATE TABLE "public"."owner" (
    "ownerid" integer NOT NULL,
    "dob" "date",
    "email" character varying(255),
    "firstname" character varying(255),
    "lastname" character varying(255),
    "phonenumber" character varying(255),
    "addressid" integer
);
    DROP TABLE "public"."owner";
       public         heap    postgres    false            �            1259    33753    owner_ownerid_seq    SEQUENCE     �   ALTER TABLE "public"."owner" ALTER COLUMN "ownerid" ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME "public"."owner_ownerid_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    205            �            1259    33765    sorn    TABLE     �   CREATE TABLE "public"."sorn" (
    "sornid" integer NOT NULL,
    "sorndate" "date",
    "sornstatus" boolean NOT NULL,
    "taxinfoid" integer
);
    DROP TABLE "public"."sorn";
       public         heap    postgres    false            �            1259    33763    sorn_sornid_seq    SEQUENCE     �   ALTER TABLE "public"."sorn" ALTER COLUMN "sornid" ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME "public"."sorn_sornid_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    207            �            1259    33772    tax_info    TABLE     �   CREATE TABLE "public"."tax_info" (
    "taxinfoid" integer NOT NULL,
    "taxduration" integer NOT NULL,
    "taxexpirydate" "date",
    "taxstartdate" "date",
    "carid" integer
);
     DROP TABLE "public"."tax_info";
       public         heap    postgres    false            �            1259    33770    tax_info_taxinfoid_seq    SEQUENCE     �   ALTER TABLE "public"."tax_info" ALTER COLUMN "taxinfoid" ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME "public"."tax_info_taxinfoid_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    209            �            1259    33779    tax_payment    TABLE       CREATE TABLE "public"."tax_payment" (
    "taxpaymentid" integer NOT NULL,
    "accountnumber" character varying(255),
    "cardnumber" character varying(255),
    "installments" boolean NOT NULL,
    "sortcode" character varying(255),
    "taxinfoid" integer
);
 #   DROP TABLE "public"."tax_payment";
       public         heap    postgres    false            �            1259    33777    tax_payment_taxpaymentid_seq    SEQUENCE     �   ALTER TABLE "public"."tax_payment" ALTER COLUMN "taxpaymentid" ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME "public"."tax_payment_taxpaymentid_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    211            �          0    33735    address 
   TABLE DATA                 public          postgres    false    201   K-       �          0    33745    car 
   TABLE DATA                 public          postgres    false    203   �-       �          0    33755    owner 
   TABLE DATA                 public          postgres    false    205   �.       �          0    33765    sorn 
   TABLE DATA                 public          postgres    false    207   =/       �          0    33772    tax_info 
   TABLE DATA                 public          postgres    false    209   �/       �          0    33779    tax_payment 
   TABLE DATA                 public          postgres    false    211   @0       �           0    0    address_adressid_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('"public"."address_adressid_seq"', 1, true);
          public          postgres    false    200            �           0    0    car_carid_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('"public"."car_carid_seq"', 1, false);
          public          postgres    false    202            �           0    0    owner_ownerid_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('"public"."owner_ownerid_seq"', 1, false);
          public          postgres    false    204            �           0    0    sorn_sornid_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('"public"."sorn_sornid_seq"', 1, false);
          public          postgres    false    206            �           0    0    tax_info_taxinfoid_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('"public"."tax_info_taxinfoid_seq"', 1, false);
          public          postgres    false    208            �           0    0    tax_payment_taxpaymentid_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('"public"."tax_payment_taxpaymentid_seq"', 1, false);
          public          postgres    false    210            P           2606    33742    address address_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY "public"."address"
    ADD CONSTRAINT "address_pkey" PRIMARY KEY ("adressid");
 D   ALTER TABLE ONLY "public"."address" DROP CONSTRAINT "address_pkey";
       public            postgres    false    201            R           2606    33752    car car_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY "public"."car"
    ADD CONSTRAINT "car_pkey" PRIMARY KEY ("carid");
 <   ALTER TABLE ONLY "public"."car" DROP CONSTRAINT "car_pkey";
       public            postgres    false    203            T           2606    33762    owner owner_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY "public"."owner"
    ADD CONSTRAINT "owner_pkey" PRIMARY KEY ("ownerid");
 @   ALTER TABLE ONLY "public"."owner" DROP CONSTRAINT "owner_pkey";
       public            postgres    false    205            V           2606    33769    sorn sorn_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY "public"."sorn"
    ADD CONSTRAINT "sorn_pkey" PRIMARY KEY ("sornid");
 >   ALTER TABLE ONLY "public"."sorn" DROP CONSTRAINT "sorn_pkey";
       public            postgres    false    207            X           2606    33776    tax_info tax_info_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY "public"."tax_info"
    ADD CONSTRAINT "tax_info_pkey" PRIMARY KEY ("taxinfoid");
 F   ALTER TABLE ONLY "public"."tax_info" DROP CONSTRAINT "tax_info_pkey";
       public            postgres    false    209            Z           2606    33786    tax_payment tax_payment_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY "public"."tax_payment"
    ADD CONSTRAINT "tax_payment_pkey" PRIMARY KEY ("taxpaymentid");
 L   ALTER TABLE ONLY "public"."tax_payment" DROP CONSTRAINT "tax_payment_pkey";
       public            postgres    false    211            [           2606    33787    car fk9uuta9w5qcl3c29qerw8jfest    FK CONSTRAINT     �   ALTER TABLE ONLY "public"."car"
    ADD CONSTRAINT "fk9uuta9w5qcl3c29qerw8jfest" FOREIGN KEY ("ownerid") REFERENCES "public"."owner"("ownerid");
 O   ALTER TABLE ONLY "public"."car" DROP CONSTRAINT "fk9uuta9w5qcl3c29qerw8jfest";
       public          postgres    false    3156    205    203            _           2606    33807 '   tax_payment fkf3s2uk8l1ay6i473ns2qcfad8    FK CONSTRAINT     �   ALTER TABLE ONLY "public"."tax_payment"
    ADD CONSTRAINT "fkf3s2uk8l1ay6i473ns2qcfad8" FOREIGN KEY ("taxinfoid") REFERENCES "public"."tax_info"("taxinfoid");
 W   ALTER TABLE ONLY "public"."tax_payment" DROP CONSTRAINT "fkf3s2uk8l1ay6i473ns2qcfad8";
       public          postgres    false    211    3160    209            ^           2606    33802 $   tax_info fkfkk6fl76hw727fgfynghv6mao    FK CONSTRAINT     �   ALTER TABLE ONLY "public"."tax_info"
    ADD CONSTRAINT "fkfkk6fl76hw727fgfynghv6mao" FOREIGN KEY ("carid") REFERENCES "public"."car"("carid");
 T   ALTER TABLE ONLY "public"."tax_info" DROP CONSTRAINT "fkfkk6fl76hw727fgfynghv6mao";
       public          postgres    false    209    3154    203            ]           2606    33797     sorn fkh9t5jgsmrppg4qf6qxxb9s6uv    FK CONSTRAINT     �   ALTER TABLE ONLY "public"."sorn"
    ADD CONSTRAINT "fkh9t5jgsmrppg4qf6qxxb9s6uv" FOREIGN KEY ("taxinfoid") REFERENCES "public"."tax_info"("taxinfoid");
 P   ALTER TABLE ONLY "public"."sorn" DROP CONSTRAINT "fkh9t5jgsmrppg4qf6qxxb9s6uv";
       public          postgres    false    3160    207    209            \           2606    33792 !   owner fkivfr52kseouoxcu9742woq2hg    FK CONSTRAINT     �   ALTER TABLE ONLY "public"."owner"
    ADD CONSTRAINT "fkivfr52kseouoxcu9742woq2hg" FOREIGN KEY ("addressid") REFERENCES "public"."address"("adressid");
 Q   ALTER TABLE ONLY "public"."owner" DROP CONSTRAINT "fkivfr52kseouoxcu9742woq2hg";
       public          postgres    false    205    201    3152            �   �   x�=��
�@��O1�E	�����FB�WwAgeg7��s;t����ne�AUwW���i;����, �4i���'g?�DjAc�/=��a7���,�)���M���Ē�Y��7>����a�}hs��|���'�!(_H��E��6�      �   �   x���v
Q���WP*(M��LV�SJN,RR� Q�)J:
Ji��9%�� v^inRjQANb	�[����������_Z�$�����/�K��������a���^�ZR���dDXx����N9�� �#?/%�0Դ��� w0      �   �   x�E�A�0�����]TPqf�t��!Һon��m2��~���yO�v��������Nb@	�o��������DL��,�"�;�ȟ�Q+�6Im�*a��e���˽� �����8�q�}k#1��r�d���+gn�bWf����U=�� Z�5�      �   h   x���v
Q���WP*(M��LV�S*�/�SR� ә)J:
`VJbI*�]\�XRZ�$Vd���i*�9���+h�(�3�2K*�u�s�Su5����  �"�      �   {   x���v
Q���WP*(M��LV�S*I����K�WR� �A��%'��(�$3?�M�(�,�LI,I�
�$���ɉE@��
a�>���
�:
f:
�FF���F��p��g�i��� .3*�      �   �   x�E��
�@E�~�c6*hdZ�Z�� �m��:#������=��mڮ��д���I	�a�����R;����`\��~��Bp;�M���i��J��%e�R�e�'���r�;����~_���bΐ�#���^ҪJ�*ͩ��S_��7Z     