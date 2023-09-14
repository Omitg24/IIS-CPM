<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE helpset
  PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN"
         "http://java.sun.com/products/javahelp/helpset_1_0.dtd">


<helpset version="1.0">
  <!-- title -->
  <title>Ayuda - El Corte Ingles: Panel de Regalos</title>

  <!-- maps -->
  <maps>
     <homeID>Introduccion</homeID>
     <mapref location="Map.jhm"/>
  </maps>

  <!-- views -->
  <view>
    <name>Tabla de contenidos</name>
    <label>Tabla de contenidos</label>
    <type>javax.help.TOCView</type>
    <data>TOC.xml</data>
  </view>

  <view>
    <name>Indice</name>
    <label>Indice</label>
    <type>javax.help.IndexView</type>
    <data>Indice.xml</data>
  </view>

  <view>
    <name>Busqueda</name>
    <label>Busqueda</label>
    <type>javax.help.SearchView</type>
    <data engine="com.sun.java.help.search.DefaultSearchEngine">
      JavaHelpSearch
    </data>
  </view>

</helpset>
