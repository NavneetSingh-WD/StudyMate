import { Button } from '@/components/ui/button'
import Link from 'next/link'

export default function HomePage() {
  return (
    <div className="container mx-auto px-4 py-16">
      <div className="max-w-3xl mx-auto text-center">
        <h1 className="text-4xl md:text-6xl font-bold text-foreground mb-6">
          Welcome to StudyMate
        </h1>
        <p className="text-xl text-muted-foreground mb-8 leading-relaxed">
          Your comprehensive study companion for managing attendance, tasks,
          study materials, and collaboration with fellow students.
        </p>
        <div className="flex flex-col sm:flex-row gap-4 justify-center">
          <Button asChild size="lg">
            <Link href="/roadmap">View Roadmap</Link>
          </Button>
          <Button asChild variant="outline" size="lg">
            <Link href="/dashboard">Go to Dashboard</Link>
          </Button>
        </div>
      </div>

      <div className="mt-16 grid md:grid-cols-3 gap-8 max-w-4xl mx-auto">
        <div className="text-center p-6 rounded-lg border">
          <h3 className="text-lg font-semibold mb-2">Attendance Tracking</h3>
          <p className="text-muted-foreground">
            Keep track of your class attendance with an intelligent timetable
            system.
          </p>
        </div>
        <div className="text-center p-6 rounded-lg border">
          <h3 className="text-lg font-semibold mb-2">Task Management</h3>
          <p className="text-muted-foreground">
            Organize assignments, deadlines, and study goals in one place.
          </p>
        </div>
        <div className="text-center p-6 rounded-lg border">
          <h3 className="text-lg font-semibold mb-2">Study Materials</h3>
          <p className="text-muted-foreground">
            Access and share study resources based on your semester and
            subjects.
          </p>
        </div>
      </div>
    </div>
  )
}
