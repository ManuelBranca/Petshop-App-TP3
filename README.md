# 🐾 PetShop App – TP3

Aplicación mobile desarrollada en **Android con Jetpack Compose** para una tienda de mascotas.

---

## 🎯 Propósito del Proyecto

El objetivo del proyecto es desarrollar una aplicación Android moderna que permita
explorar productos para mascotas, gestionar favoritos, realizar búsquedas y navegar
entre distintas secciones, aplicando **buenas prácticas de UI, navegación y diseño responsive**.

---

## 📱 Descripción del Proyecto

**PetShop App** es una aplicación Android que incluye:

- Login con Firebase Authentication
- Home con productos destacados
- Detalle de producto
- Gestión de favoritos (persistidos en Firebase)
- Carrito de compras
- Perfil de usuario y pantalla de configuración
- Diseño responsive para distintos tamaños de pantalla

> ⚠️ En esta versión no se permite crear usuarios desde la app.  
> Los usuarios ya están creados para fines de prueba.

---

## 🔐 Usuarios de prueba

Para ingresar a la aplicación:

- **Email:** manuel@gmail.com  
  **Password:** 123456

- **Email:** franco@gmail.com  
  **Password:** 123456

---

## 🛠 Tecnologías Utilizadas

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Navigation Compose**
- **Hilt (Dependency Injection)**
- **Firebase Authentication**
- **Firebase Firestore**
- **Coil (Image Loading)**

---

## 📦 Dependencias Principales

- `androidx.compose.ui`
- `androidx.compose.material3`
- `androidx.navigation:navigation-compose`
- `com.google.dagger:hilt-android`
- `com.google.firebase:firebase-auth`
- `com.google.firebase:firebase-firestore`
- `io.coil-kt:coil-compose`

Las dependencias completas pueden verse en el archivo `build.gradle.kts`.

---

## 📐 Diseño Responsive

La aplicación implementa un sistema de dimensiones dinámicas mediante
`rememberPhoneDimens`, permitiendo una correcta visualización en:

- Pantallas pequeñas (Small)
- Pantallas medianas (Normal)
- Pantallas grandes (Large)

Se utilizan scrolls, tamaños adaptativos y espaciados variables según resolución.

---

## 👥 Integrantes

- Manuel Branca  
- Franco Paganucci  

---

## 🚀 Cómo levantar el proyecto

### Requisitos
- Android Studio
- JDK 17
- Emulador o dispositivo Android
- Conexión a Internet

### Pasos

1. Clonar el repositorio:
```bash
git clone https://github.com/ManuelBranca/Petshop-App-TP3.git
```

1. Abrir el proyecto en Android Studio

2. Sincronizar Gradle

3. Ejecutar la aplicación en un emulador o dispositivo

4. Ingresar con alguno de los usuarios de prueba
