<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\SessionTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\SessionTable Test Case
 */
class SessionTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\SessionTable
     */
    public $Session;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.session',
        'app.count_observations',
        'app.count_observations_session',
        'app.count_observations_sessions_user'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('Session') ? [] : ['className' => SessionTable::class];
        $this->Session = TableRegistry::get('Session', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->Session);

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
