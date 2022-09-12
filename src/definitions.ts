export interface LocalStorageMigratorPlugin {
  read(data: { key: string }): Promise<{ value: string | null }>;
}
