# 🪙 CryptoBlink

A modern Android application for exploring cryptocurrency information and real-time price tracking using Jetpack Compose.

## 📋 Overview

**CryptoBlink** is an elegant Android app that provides users with comprehensive cryptocurrency data. Browse through a list of cryptocurrencies, view detailed information about each coin, check real-time prices, and explore the teams behind popular crypto projects.

## ✨ Features

### 🔍 **Cryptocurrency List**
- Browse a comprehensive list of cryptocurrencies
- Instantly discover top crypto coins with their current rankings

### 💰 **Real-Time Price Tracking**
- View current cryptocurrency prices in USD
- Automatic price conversion and formatting
- Clean, intuitive price display

### 📊 **Detailed Coin Information**
Each cryptocurrency detail screen shows:
- **Coin Ranking & Identity** - Position, name, and symbol (e.g., #1 Bitcoin (BTC))
- **Live Price** - Current market price with color coding (Green for active, Red for inactive coins)
- **Project Description** - Comprehensive details about the cryptocurrency project
- **Tags** - Categorized tags for quick identification (e.g., Blockchain, Mining, etc.)
- **Team Members** - List of key team members involved in the project development

### 👥 **Team Insights**
- View team member details including positions and roles
- Organized team member list for each cryptocurrency project

## 🏗️ Architecture

CryptoBlink follows **Clean Architecture** principles with:

- **Presentation Layer** - Jetpack Compose UI with MVVM pattern
- **Domain Layer** - Use cases and business logic
- **Data Layer** - Repository pattern with Retrofit for API calls

### Key Technologies:
- **Jetpack Compose** - Modern UI toolkit
- **Kotlin Coroutines** - Asynchronous programming
- **Hilt** - Dependency injection
- **Retrofit** - REST API client
- **Flow** - Reactive data streams
- **Compose Material** - Material Design components

## 🔌 API Integration

The app uses the **CoinPaprika API** for cryptocurrency data:

```
Base URL: https://api.coinpaprika.com/v1/

Endpoints:
- /coins - Get list of all cryptocurrencies
- /coins/{coinId} - Get detailed information about a specific coin
- /price-converter - Convert cryptocurrency prices to USD
```

### Price Converter Example:
```
GET /v1/price-converter?base_currency_id=btc-bitcoin&quote_currency_id=usd-us-dollars&amount=1
```

## 📱 User Flow

1. **Home Screen** → View list of cryptocurrencies
2. **Select Coin** → Tap any cryptocurrency to view details
3. **Detail Screen** → View comprehensive coin information:
   - Current price
   - Project description
   - Associated tags
   - Team members information

## 📂 Project Structure

```
app/src/main/java/com/mranasspro/cryptoblink/
├── presentation/
│   ├── coin_list/          # Cryptocurrency list screen
│   └── coin_detail/        # Detailed coin information screen
├── domain/
│   ├── use_case/           # Business logic
│   └── model/              # Domain models
├── data/
│   ├── remote/             # API calls & Retrofit
│   └── repository/         # Data repository implementation
└── common/
    └── Constants/          # App constants & utilities
```

## 🎨 UI/UX Highlights

- **Modern Compose UI** - Built entirely with Jetpack Compose
- **Responsive Layout** - Adapts to different screen sizes
- **Color-Coded Status** - Green for active coins, Red for inactive
- **Smooth Navigation** - Seamless transitions between screens
- **Loading States** - Progress indicators for data fetching
- **Error Handling** - User-friendly error messages

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest version)
- Android SDK 21+
- Internet connection for API calls

### Build & Run
```bash
# Clone the repository
git clone [repository-url]

# Open in Android Studio
cd CryptoBlink

# Build and run
./gradlew build
```

## 🧪 Testing

Unit tests for UI components and business logic:
```bash
./gradlew test              # Run unit tests
./gradlew connectedAndroidTest  # Run instrumented tests
```

## 📝 Example: Viewing Bitcoin Details

1. Launch the app
2. Scroll through the crypto list
3. Tap on "Bitcoin (BTC)"
4. View:
   - Rank: #1
   - Name: Bitcoin
   - Price: $XXXXX.XX (converted from API)
   - Description: Technical details about Bitcoin
   - Tags: Blockchain, Mining, Store-of-value, etc.
   - Team: View Bitcoin development team members

## 🔄 State Management

The app uses **Jetpack Compose State Management** with:
- `State<T>` for UI state observation
- `mutableStateOf()` for state updates
- **ViewModel** for state persistence
- **Coroutine Flow** for reactive data streams

## 📡 Data Flow

```
API Response 
    ↓
Repository (CoinRepositoryImpl)
    ↓
Use Cases (GetCoinUseCase, GetCoinPriceUseCase)
    ↓
ViewModel (CoinDetailViewModel)
    ↓
UI State (CoinDetailState, CoinPriceState)
    ↓
Composable UI (CoinDetailScreen)
```

## 🛠️ Development Notes

- **Price Conversion** - All prices are converted to USD using the `roundToTwoDigits()` utility
- **Currency ID** - Base currency is dynamically set based on the selected coin
- **Quote Currency** - Default quote currency is USD ("usd-us-dollars")
- **Error Handling** - Network errors and API failures are gracefully handled with user-friendly messages

## 📦 Dependencies

Key libraries used:
- `androidx.compose.*` - Jetpack Compose
- `com.squareup.retrofit2` - Retrofit HTTP client
- `com.google.dagger:hilt-android` - Dependency injection
- `org.jetbrains.kotlinx:kotlinx-coroutines` - Coroutines for async programming
- `androidx.lifecycle:lifecycle-viewmodel-compose` - MVVM clean architecture with use cases

## 🤝 Contributing

Feel free to fork, modify, and improve this project!

## 📄 License

This project is open source and available under the MIT License.

---

**Happy exploring! 🚀 Discover the world of cryptocurrency with CryptoBlink.**
