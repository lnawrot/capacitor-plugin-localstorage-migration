export interface LocalStorageMigratorPlugin {
  read(key: string): Promise<{ value: string | null }>;
}
