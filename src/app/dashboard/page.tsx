import { Button } from '@/components/ui/button'
import Link from 'next/link'

export default function DashboardPage() {
  return (
    <div className="container mx-auto px-4 py-16">
      <div className="max-w-3xl mx-auto">
        <h1 className="text-3xl md:text-4xl font-bold text-foreground mb-6">
          StudyMate Dashboard
        </h1>

        <div className="bg-muted/50 border border-dashed rounded-lg p-8 text-center">
          <h2 className="text-xl font-semibold mb-4">Under Construction</h2>
          <p className="text-muted-foreground mb-6">
            This page will provide a comprehensive dashboard for managing your
            attendance, tasks, study materials, and academic progress.
          </p>
          <p className="text-sm text-muted-foreground mb-4">
            📝 <strong>TODO:</strong> CRUD operations and dashboard features
            tracked in{' '}
            <span className="font-mono bg-muted px-2 py-1 rounded">
              Issue #25
            </span>
          </p>
          <Button asChild variant="outline">
            <Link href="/">Back to Home</Link>
          </Button>
        </div>
      </div>
    </div>
  )
}
