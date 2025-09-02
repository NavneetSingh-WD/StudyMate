# StudyMate

StudyMate is a modern web application designed to help college students manage their attendance, tasks, study materials, and collaboration with fellow students. Built with Next.js 14+, TypeScript, and Tailwind CSS.

## Features

- **Attendance Management**: Track class attendance with intelligent timetable integration
- **Task Management**: Organize assignments, deadlines, and study goals
- **Study Materials**: Access and share resources based on semester and subjects
- **Student Collaboration**: Connect and communicate with classmates
- **AI Integration**: AI-powered assistance for academic queries
- **Secure Environment**: Privacy-focused design for student data protection

## Tech Stack

- **Framework**: Next.js 14+ with App Router
- **Language**: TypeScript (strict mode)
- **Styling**: Tailwind CSS
- **UI Components**: shadcn/ui with Radix UI
- **Linting**: ESLint + Prettier
- **Package Manager**: pnpm
- **CI/CD**: GitHub Actions

## Prerequisites

- Node.js 20.x or higher
- pnpm (recommended) or npm

## Getting Started

1. **Clone the repository**:

   ```bash
   git clone https://github.com/NavneetSingh-WD/StudyMate.git
   cd StudyMate
   ```

2. **Install dependencies**:

   ```bash
   pnpm install
   ```

3. **Set up environment variables**:

   ```bash
   cp .env.example .env.local
   # Edit .env.local with your configuration
   ```

4. **Run the development server**:

   ```bash
   pnpm dev
   ```

5. **Open your browser**:
   Visit [http://localhost:3000](http://localhost:3000) to see the application.

## Development Scripts

- `pnpm dev` - Start development server
- `pnpm build` - Build for production
- `pnpm start` - Start production server
- `pnpm lint` - Run ESLint
- `pnpm typecheck` - Run TypeScript type checking
- `pnpm format` - Format code with Prettier
- `pnpm format:check` - Check code formatting

## Project Structure

```
StudyMate/
├── src/
│   ├── app/                 # Next.js App Router pages
│   │   ├── dashboard/       # Dashboard page (Issue #25)
│   │   ├── roadmap/         # Roadmap page (Issue #20)
│   │   ├── globals.css      # Global styles
│   │   ├── layout.tsx       # Root layout
│   │   └── page.tsx         # Home page
│   ├── components/
│   │   └── ui/              # shadcn/ui components
│   └── lib/
│       └── utils.ts         # Utility functions
├── .github/workflows/       # CI/CD workflows
└── ...config files
```

## Upcoming Features

The following features are planned for future releases:

- **Database Integration** (Prisma + PostgreSQL)
- **Authentication** (Auth.js)
- **Email System** (Resend)
- **Subscription Management**
- **Rate Limiting**
- **Advanced Dashboard CRUD Operations**

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is private and proprietary. All rights reserved.

## Support

For support and questions, please open an issue in the GitHub repository.
