<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\CountSessionsTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\CountSessionsTable Test Case
 */
class CountSessionsTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\CountSessionsTable
     */
    public $CountSessions;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.count_sessions'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('CountSessions') ? [] : ['className' => CountSessionsTable::class];
        $this->CountSessions = TableRegistry::get('CountSessions', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->CountSessions);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
